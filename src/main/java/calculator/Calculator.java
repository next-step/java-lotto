package calculator;

import java.util.Arrays;
import java.util.Iterator;

public class Calculator {
    public static int calculate(String formula){
        validEmptyFormula(formula);
        Iterator<String> iterator = getSplitString(formula);
        int result = Integer.parseInt(iterator.next());
        while(iterator.hasNext()){
            Operator operator = Operator.getOperatorBySymbol(iterator.next());
            result = operator.calculate(result, Integer.parseInt(iterator.next()));
        }

        return result;
    }

    private static void validEmptyFormula(String formula){
        if(formula == null || formula.trim().isEmpty()){
            throw new IllegalArgumentException("입력 값은 null이거나 빈 공백일 수 없습니다.");
        }
    }

    private static Iterator<String> getSplitString(String formula){
        return Arrays.stream(formula.split(" ")).iterator();
    }
}
