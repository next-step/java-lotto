package stringcalculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Input {

    public static final String SPACE = " ";
    public static final String NOT_ALLOW_BELOW_THREE_OR_LIST_SIZE_EVEN_NUMBER = "잘못된 문자열을 입력했습니다.(공백 2개 이상, 숫자 연산자 숫자(2 * 3) 형태)";
    public static final int MIN_SIZE = 3;
    public static final int EVEN_CHECK_NUMBER = 2;
    public static final int ZERO = 0;
    private final List<String> inputs;

    public Input(String concatenatedInput) {
        this.inputs = split(concatenatedInput);
    }

    public static Input of(final String[] inputs) {
        return new Input(String.join(SPACE, inputs));
    }

    private List<String> split(String input) {
        String[] inputs = input.trim()
                .split(SPACE);
        List<String> result = Arrays.stream(inputs)
                .collect(Collectors.toUnmodifiableList());

        if (isInvalidateSize(result.size())) {
            throw new IllegalArgumentException(NOT_ALLOW_BELOW_THREE_OR_LIST_SIZE_EVEN_NUMBER);
        }

        return result;
    }

    private static boolean isInvalidateSize(int size) {
        return size < MIN_SIZE ||
                size % EVEN_CHECK_NUMBER == ZERO;
    }

    public List<String> value() {
        return this.inputs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Input input = (Input) o;
        return Objects.equals(inputs, input.inputs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputs);
    }
}
