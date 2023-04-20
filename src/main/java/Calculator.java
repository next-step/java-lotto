import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private static final String FORMULA_REGEX = "^[0-9+\\-*/\\s]*$";
    private static List<BasicOperator> operations = new ArrayList<>();
    private static List<Integer> numbers = new ArrayList<>();
    private static int calculationResult;


    public static int calculate(String formula) {
        validateFormula(formula);
        String[] nums = formula.split(" ");

        operations = Arrays.stream(nums)
                .filter(BasicOperator::hasOperator)
                .map(BasicOperator::find)
                .collect(Collectors.toList());

        numbers = Arrays.stream(nums)
                .filter(str -> !BasicOperator.hasOperator(str))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        
        calculationResult = numbers.get(0);

        for(int i=1; i<numbers.size(); i++){
            BasicOperator operator = operations.get(i-1);
            int number = numbers.get(i);
            calculationResult = operator.apply(calculationResult, number);
        }
        return calculationResult;
    }

    private static void validateFormula(String formula){
        if(!formula.matches(FORMULA_REGEX)){
            throw new IllegalArgumentException("숫자와 사칙연산 기호만이 입력 되어야 합니다.");
        }
    }
}
