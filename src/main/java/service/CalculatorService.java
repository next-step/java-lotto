package service;

import constants.Operator;

import java.util.List;

public class CalculatorService {

    public int calculate(String calculationFormula) {

        Preprocessor preprocessor = new Preprocessor();
        List<String> processedValue = preprocessor.process(calculationFormula);

        return calculateStart(processedValue);
    }

    private int calculateStart(List<String> calculateTargets) {

        int result = Integer.parseInt(calculateTargets.get(0));

        for(int i = 1; i < calculateTargets.size(); i+=2) {
            int nextNumber = Integer.parseInt(calculateTargets.get(i + 1));
            result = chooseOperator(calculateTargets.get(i))
                    .calculate(result, nextNumber);
        }

        return result;
    }

    private CalculatorInterface chooseOperator(String calculateTarget) {

        Operator operator = Operator.find(calculateTarget);
        if(operator == null) {
            throw new IllegalArgumentException("연산자를 찾을 수 없습니다.");
        }

        return operator.getCalculatorInterface();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
