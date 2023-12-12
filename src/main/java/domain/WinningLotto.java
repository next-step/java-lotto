package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static util.LottoNumberGenerator.LOTTO_NUMBER_COUNT_LIMIT;

public class WinningLotto {
    private Set<LottoNumber> lottoNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(int num1, int num2, int num3, int num4, int num5, int num6, int bonus) {
        this(IntStream.of(num1, num2, num3, num4, num5, num6)
                        .mapToObj(LottoNumber::valueOf)
                        .collect(Collectors.toSet())
                , LottoNumber.valueOf(bonus));
    }

    public WinningLotto(String numbers, int bonus) {
        this(Arrays.stream(numbers.split(","))
                        .map(LottoNumber::from)
                        .collect(Collectors.toSet())
                , LottoNumber.valueOf(bonus));
    }

    private WinningLotto(Set<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        validateLottoNumberCount(lottoNumbers);
        validateBonusNumber(lottoNumbers, bonusNumber);

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private static void validateBonusNumber(Set<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자가 로또 숫자와 중복입니다. bonusNumber - " + bonusNumber.getNumber());
        }
    }

    private static void validateLottoNumberCount(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT_LIMIT) {
            throw new IllegalArgumentException("로또 숫자는 6개 입니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .collect(Collectors.toList());
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lottoNumbers=" + lottoNumbers +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
