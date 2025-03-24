package calculator;


import data.Messages;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Calculator {

    private int result = 0;
    private final Formula formula;
    private final Map<String, Consumer<Integer>> calculateConsumerMap;

    Calculator(int init) {
        this(init, "0");
    }

    public Calculator(String formula) {
        this(0, formula);
    }

    public Calculator(int init, String formula) {
        this.result = init;
        this.formula = new Formula(formula);

        calculateConsumerMap = new HashMap<>();
        calculateConsumerMap.put("+", this::add);
        calculateConsumerMap.put("-", this::subtract);
        calculateConsumerMap.put("*", this::multiply);
        calculateConsumerMap.put("/", this::divide);
    }

    public int getResult() {
        return result;
    }

    public int add(int num) {
        return result += num;
    }

    public int subtract(int num) {
        return result -= num;
    }

    public int multiply(int num) {
        return result *= num;
    }

    public int divide(int num) {
        if (result % num != 0) {
            throw new IllegalArgumentException(Messages.TYPE_ERROR);
        }
        return result /= num;
    }

    public void calculate(String sign, String numStr) {
        if(!calculateConsumerMap.containsKey(sign)){
            throw new IllegalArgumentException(Messages.TYPE_ERROR);
        }
        calculateConsumerMap.get(sign).accept(Integer.parseInt(numStr));
    }

    public int calculateFormula() {
        String[] calTargetArr = this.formula.getCalculateTarget();
        for (int i = 0; i < calTargetArr.length / 2; i++) {
            this.calculate(calTargetArr[i * 2], calTargetArr[i * 2 + 1]);
        }
        return this.getResult();
    }
}