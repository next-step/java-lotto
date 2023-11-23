package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {

    private static final int LOTTO_NUMBER_COUNT_LIMIT = 6;
    private Set<LottoNumber> lottoNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(int bonus, Integer... numbers) {
        this(Arrays.stream(numbers).collect(Collectors.toList()), bonus);
    }

    public WinningLotto(String numbers, int bonus) {
        this(Arrays.stream(numbers.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                , bonus);
    }

    public WinningLotto(List<Integer> lottoNumbers, int bonus) {
        Set<Integer> numbers = new HashSet<>(lottoNumbers);
        validateLottoNumberCount(numbers);

        this.lottoNumbers = lottoNumbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        this.bonusNumber = new LottoNumber(bonus);
    }

    private static void validateLottoNumberCount(Set<Integer> lottoNumbers) {
        if (lottoNumbers.stream().count() < LOTTO_NUMBER_COUNT_LIMIT) {
            throw new IllegalArgumentException("로또 숫자는 6개 입니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        return bonusNumber.getLottoNumber();
    }
}
