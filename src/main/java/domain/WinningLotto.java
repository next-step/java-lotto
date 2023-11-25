package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {

    private static final int LOTTO_NUMBER_COUNT_LIMIT = 6;
    private Set<LottoNumber> lottoNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(int bonus, Integer... numbers) {
        this(Arrays.stream(numbers)
                        .map(LottoNumber::new)
                        .collect(Collectors.toSet())
                , bonus);
    }

    public WinningLotto(String numbers, int bonus) {
        this(Arrays.stream(numbers.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .map(LottoNumber::new)
                        .collect(Collectors.toSet())
                , bonus);
    }

    public WinningLotto(Set<LottoNumber> lottoNumbers, int bonus) {
        validateLottoNumberCount(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = new LottoNumber(bonus);
    }

    private static void validateLottoNumberCount(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() < LOTTO_NUMBER_COUNT_LIMIT) {
            throw new IllegalArgumentException("로또 숫자는 6개 입니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .sorted()
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        return bonusNumber.getLottoNumber();
    }
}
