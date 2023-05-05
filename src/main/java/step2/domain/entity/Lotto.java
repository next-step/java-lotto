package step2.domain.entity;

import step2.domain.vo.LottoNumber;
import step2.domain.vo.LottoPrize;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int PRICE = 1_000;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int SECOND_LOTTO_COUNT = 5;

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(int... numbers) {
        this.lottoNumbers = Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private Lotto(String number) {
        this.lottoNumbers = toLottoNumbers(split(number));
    }

    public static Lotto winner(String number) {
        return new Lotto(number);
    }

    private String[] split(String number) {
        return number.split(",");
    }

    private List<LottoNumber> toLottoNumbers(String[] numbers) {
        validateLottoNumbers(numbers);

        return Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validateLottoNumbers(String[] numbers) {
        if (numbers.length != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoPrize prize(Lotto compareLotto, LottoNumber bonus) {
        // compare: 로또 번호, lottoNumbers: 당첨 번호
        final var compare = compareLotto.getLottoNumbers();
        final var count = (int) lottoNumbers.stream()
                .filter(compare::contains)
                .count();

        if (isSecondBonusLotto(bonus, compare, count)) {
            return LottoPrize.SECOND_BONUS;
        }

        return LottoPrize.prize(count);
    }

    private static boolean isSecondBonusLotto(LottoNumber bonus, List<LottoNumber> compare, int count) {
        return count == SECOND_LOTTO_COUNT && compare.contains(bonus);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
