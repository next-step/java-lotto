package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Operand {

    private int operand;

    public Operand(int operand) {
        this.operand = this.validate(operand);
    }

    public int getOperand() {
        return this.operand;
    }

    private int validate(int operand) {
        if(operand < 0) {
            throw new RuntimeException("연산 대상은 음수일 수 없습니다.");
        }

        return operand;
    }

    public static List<Operand> parseOperand(String origin, String seperator) {
        return Arrays.stream(origin.split(seperator))
            .map(Integer::parseInt)
            .mapToInt(Integer::intValue)
            .mapToObj(a -> new Operand(a))
            .collect(Collectors.toList());
    }
}
