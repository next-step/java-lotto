package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    }

    public static Lotto of(int... numbers) {
        Lotto lotto = new Lotto();
        isPossibleLottoNumbers(numbers);
        lotto.lottoNumbers = new LottoNumbers(numbers);
        return lotto;
    }

    private static void isPossibleLottoNumbers(int[] numbers) {
        duplicateCheck(numbers);
        lengthCheck(numbers);
        for (int number : numbers) {
            isValidNumber(number);
        }
    }

    private static void duplicateCheck(int[] numbers) {
        if (Arrays.stream(numbers).distinct().count() < numbers.length) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private static void lengthCheck(int[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private static void isValidNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.getNumbers();
    }

    public int getMatchCount(Lotto lastWeekWinningLotto) {
        return (int) lottoNumbers.getNumbers().stream()
                .filter(lastWeekWinningLotto.getLottoNumbers()::contains)
                .count();
    }
}
