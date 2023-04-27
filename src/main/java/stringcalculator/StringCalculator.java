package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private final List<Double> numbers = new ArrayList<>();
    private final List<String> operatorList = new ArrayList<>();
    private Double result;

    public StringCalculator(String input) {
        validateInput(input);
        String[] strings = splitInput(input);
        result = Double.valueOf(strings[0]);
        for (int i = 0; i < strings.length; i++) {
            separateInput(strings, i);
        }
    }

    private void separateInput(String[] strings, int i) {
        if(i%2==1){
            operatorList.add(strings[i]);
            return;
        }
        numbers.add(Double.valueOf(strings[i]));
    }

    private String[] splitInput(String input) {
        return input.split(" ");
    }

    private void validateInput(String input) {
        if(input==null||input.isBlank()){
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }

    public String getOperator(int index){
        return operatorList.get(index);
    }

    public Double getNumber(int index){
        return numbers.get(index);
    }

    public Double calculate() {
        for (int i = 0; i < operatorList.size(); i++) {
            calculateEach(operatorList.get(i),numbers.get(i+1));
        }
        return result;
    }

    public void calculateEach(String symbol, Double number) {
        switch (symbol){
            case "+" : result = Operation.PLUS.calculate(result,number); break;
            case "-" : result = Operation.MINUS.calculate(result,number); break;
            case "*" : result = Operation.MULTIPLY.calculate(result,number); break;
            case "/" : result = Operation.DIVIDE.calculate(result,number); break;
        }
    }
}
