package step1.calculator;

import org.apache.commons.lang3.math.NumberUtils;
import step1.InputValue;
import step1.StringSplitter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created By mand2 on 2020-11-16.
 */
public class Inputs {

    private final List<Integer> inputs;

    private Inputs(List<Integer> inputs) {
        this.inputs = inputs;
    }

    public static Inputs of(InputValue inputValue) {
        return Inputs.of(inputValue.getInput());
    }

    public static Inputs of(String input) {
        // String to [] 로..!
        String[] strInputs = StringSplitter.split(input);

        // [] -> List Integer 로 변환
        // validation.. 음수면 안됨.
        List<Integer> inputs = Arrays.stream(strInputs)
                .map(s -> isUnderZero(s))
                .collect(Collectors.toList());

        return new Inputs(inputs);
    }

    private static int isUnderZero(String input) {
        int number = NumberUtils.toInt(input, -1);
        if (number < NumberUtils.INTEGER_ZERO) {
            throw new RuntimeException("입력한 값은 0 이상의 정수여야 합니다.");
        }
        return number;
    }

    public List<Integer> value() {
        return this.inputs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inputs inputs1 = (Inputs) o;
        return Objects.equals(inputs, inputs1.inputs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputs);
    }
}
