package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private final List<Double> numbers = new ArrayList<>();
    private final List<String> operatorList = new ArrayList<>();
    private double result;

    public StringCalculator(String input) {
        validateInput(input);
        String[] strings = splitInput(input);
        result = Double.parseDouble(strings[0]);
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
        Operation operation = Operation.find(symbol);
        if(operation == null){
            throw new IllegalArgumentException();
        }
        result = operation.calculate(result,number);
    }

    public Double getResult() {
        return result;
    }
}
