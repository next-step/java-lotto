package stringCalculator.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    String[] arguments;
    Map<String, BiFunction<Integer, Integer, Integer>> calculateStrategy = new HashMap<>();
    List<String> operators = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();
    int result;

    public Calculator(){
        setCalculateStrategy();
    }
    public Calculator(String formula){
        setCalculateStrategy();
        this.arguments = stringEmptySeparation(formula);
        numberOperatorSeparation(arguments);
        initResult(numbers.get(0));
        calculation();
    }

    private void initResult(int firstArgument){
        this.result = firstArgument;
    }

    private void setCalculateStrategy(){
        calculateStrategy.put("+", (num1, num2) -> num1 + num2);
        calculateStrategy.put("-", (num1, num2) -> num1 - num2);
        calculateStrategy.put("*", (num1, num2) -> num1 * num2);
        calculateStrategy.put("/", (num1, num2) -> num1 / num2);
    }

    String[] stringEmptySeparation(String input){
        return input.split(" ");
    }

    Boolean checkOperator(String argument){
        return argument.equals("+") || argument.equals("-") || argument.equals("*") || argument.equals("/");
    }
    
    void numberOperatorSeparation(String[] arguments){
        for(String argument : arguments){
            addNumbers(argument);
            addOperators(argument);
        }
    }

    void addNumbers(String argument){
        if(!checkOperator(argument)){
            numbers.add(Integer.valueOf(argument));
        }
    }

    void addOperators(String argument){
        if(checkOperator(argument)){
            operators.add(argument);
        }
    }

    public int calculateResult(){
        return result;
    }

    void calculation(){
        for (int i = 0; i < operators.size(); i++) {
            result = arithmeticCalculation(operators.get(i), numbers.get(i+1));
        }
    }

    int arithmeticCalculation(String operator, int argument2){
         return calculateStrategy.get(operator).apply(result, argument2);
    }



}
