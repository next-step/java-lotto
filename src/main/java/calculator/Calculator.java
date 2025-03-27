package calculator;

import data.Messages;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;

public class Calculator {

    private static int result = 0;
    private final Formula formula;

    public enum SignEnum {
        ADD("+", Calculator::add),
        SUBTRACT("-", Calculator::subtract),
        MULTIPLY("*", Calculator::multiply),
        DIVIDE("/", Calculator::divide),
        ;

        private final String sign;
        private final Consumer<Integer> consumer;

        SignEnum(String sign, Consumer<Integer> consumer) {
            this.sign = sign;
            this.consumer = consumer;
        }

        public String getSign() {
            return sign;
        }

        public static SignEnum of(String sign) {
            return Arrays.stream(values())
                    .filter(s -> s.getSign().equals(sign))
                    .findAny()
                    .orElse(null);
        }
    }

    Calculator(int init) {
        this(init, "0");
    }

    public Calculator(String formula) {
        this(0, formula);
    }

    public Calculator(int init, String formula) {
        this.result = init;
        this.formula = new Formula(formula);
    }

    public int getResult() {
        return result;
    }

    public static int add(int num) {
        return result += num;
    }

    public static int subtract(int num) {
        return result -= num;
    }

    public static int multiply(int num) {
        return result *= num;
    }

    public static int divide(int num) {
        if (result % num != 0) {
            throw new IllegalArgumentException(Messages.TYPE_ERROR);
        }
        return result /= num;
    }

    public void calculate(String sign, String numStr) {
        Optional.ofNullable(SignEnum.of(sign))
                .orElseThrow(() -> new IllegalArgumentException(Messages.TYPE_ERROR))
                .consumer.accept(Integer.parseInt(numStr));
    }

    public int calculateFormula() {
        String[] calTargetArr = this.formula.getCalculateTarget();
        for (int i = 0; i < calTargetArr.length / 2; i++) {
            this.calculate(calTargetArr[i * 2], calTargetArr[i * 2 + 1]);
        }
        return this.getResult();
    }
}