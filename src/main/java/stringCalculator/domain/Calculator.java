package stringCalculator.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    String[] arguments;
    static Map<String, Arithmetic> calculateStrategy = new HashMap<>();
    List<String> operators = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();
    int result;

    static{
        calculateStrategy.put("+", Arithmetic.PLUS);
        calculateStrategy.put("-", Arithmetic.SUBTRACT);
        calculateStrategy.put("*", Arithmetic.MULTIPLY);
        calculateStrategy.put("/", Arithmetic.DIVIDE);
    }

    public Calculator(){
    }
    public Calculator(String formula){

        this.arguments = stringEmptySeparation(formula);
        numberOperatorSeparation(arguments);
        initResult(numbers.get(0));
    }

    private void initResult(int firstArgument){
        this.result = firstArgument;
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
        calculation();
        return result;
    }

    void calculation(){
        for (int i = 0; i < operators.size(); i++) {
            result = arithmeticCalculation(operators.get(i), result, numbers.get(i+1));
        }
    }

    int arithmeticCalculation(String operator, int argument1, int argument2){
          return calculateStrategy.get(operator).calculate(argument1, argument2);

    }
}
