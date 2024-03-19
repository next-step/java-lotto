package domain;

import java.util.List;

public class CalculateHandler {

    public int handle(SeparationDto dto){
        List<Integer> numbers = dto.getNumbers();
        List<String> values = dto.getOperators();
        int result = numbers.get(0);
        result = calculate(numbers, values, result);
        return result;
    }

    private int calculate(List<Integer> numbers, List<String> values, int result) {
        Operator operator;
        for(int i = 0; i < values.size(); i++){
            operator = Operator.toOperator(values.get(i));
            result = operator.apply(result, numbers.get(i+1));
        }
        return result;
    }
}
