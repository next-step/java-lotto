package auto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public final static int LOTTO_MIN_NUMBER = 1;
    public final static int LOTTO_MAX_NUMBER = 45;
    private static final String LOTTO_NUMBER_SIZE_ERROR_TEXT = "로또 번호는 6개의 숫자로 이루어져야 합니다.";
    private static final int MAXIMUM_LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers == null || numbers.size() != MAXIMUM_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR_TEXT);
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return "" + numbers;
    }

    public static Lotto createLottoNumbers() {
        List<Integer> numbers = IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER + 1)
                                         .boxed()
                                         .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, 6));
    }
}
