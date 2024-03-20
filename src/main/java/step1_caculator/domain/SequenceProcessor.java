package step1_caculator.domain;

import step1_caculator.type.OperatorType;

import java.util.List;

public class SequenceProcessor {
    private static final String INTEGER_REGEX = "-?\\d+";
    private CalculationExecutor calculationExecutor;
    public SequenceProcessor(CalculationExecutor calculationExecutor) {
        this.calculationExecutor = calculationExecutor;
    }

    public int process(List<String> inputs){

        for (String input : inputs) {
            if(OperatorType.isOperator(input)){
                calculationExecutor.saveOperatorType(OperatorType.of(input));
            }
            if(input.matches(INTEGER_REGEX)){
                calculationExecutor.calculate(Integer.parseInt(input));
                calculationExecutor.resetOperatorType();
            }
        }

        return calculationExecutor.getResult();
    }

}




