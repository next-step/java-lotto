package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLottoNumbers {

    public static final int NUMBER_COUNT = 7;

    private LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;


    public WinningLottoNumbers(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if(lottoNumbers.numbers().contains(bonusNumber.number())) {
            throw new IllegalArgumentException("보너스 번호는 로또 당첨 번호에 포함될 수 없습니다.");
        }

        this.lottoNumbers = new LottoNumbers(lottoNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }
    public WinningLottoNumbers(List<LottoNumber> numbers) {
        LottoNumbers.validate(numbers, NUMBER_COUNT);

        this.bonusNumber = numbers.get(numbers.size() - 1);
        this.lottoNumbers = new LottoNumbers(numbers.subList(0, numbers.size() - 1));
    }

    public static WinningLottoNumbers fromIntegers(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new WinningLottoNumbers(lottoNumbers);
    }

    public static WinningLottoNumbers toLottoNumbers(String lottoNumbersText, String bonusText) {
        LottoNumbers lottoNumber = LottoNumbers.toLottoNumber(lottoNumbersText);
        LottoNumber bonusNumber = new LottoNumber(Integer.parseInt(bonusText));

        return new WinningLottoNumbers(lottoNumber, bonusNumber);
    }
    public LottoRank lottoRank(LottoNumbers lottoNumbers) {
        Set<LottoNumber> numberSet = new HashSet<>(lottoNumbers.numbers());
        int match = (int) this.lottoNumbers.numbers()
                .stream()
                .filter(numberSet::contains)
                .count();

        boolean bonusMatch = numberSet.contains(this.bonusNumber);
        return LottoRank.fromMatch(match, bonusMatch);
    }
}
