package humbledude.lotto;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    public static final int LOTTO_SIZE_OF_NUMBERS = 6;

    private final Set<Integer> numbers;

    private LottoNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
        validateNumbers();
    }

    public static LottoNumbers of(Set<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    public static LottoNumbers of(int num1, int num2, int num3, int num4, int num5, int num6) {
        return new LottoNumbers(
                IntStream.of(num1, num2, num3, num4, num5, num6)
                        .boxed()
                        .collect(Collectors.toSet())
        );
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumbers() {
        if (numbers.size() != LOTTO_SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException("로또는 겹치지 않는 6개 숫자로만 만들수 있어요");
        }
        for (Integer number : numbers) {
            validateNumber(number);
        }
    }

    private void validateNumber(Integer number) {
        if (number < LOTTO_MIN || number > LOTTO_MAX) {
            throw new IllegalArgumentException("로또는 " + LOTTO_MIN + "부터 " + LOTTO_MAX + "까지의 숫자만 쓸 수 있어요");
        }
    }
}
