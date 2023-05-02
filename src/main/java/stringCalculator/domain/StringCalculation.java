package stringCalculator.domain;

import java.util.List;

public class StringCalculation {
    public static int result = 0;

    public StringCalculation(){
    }

    public static void calculate(Numbers numbers, Operators operators) {
        setFirstNumber(numbers.getFirstNumber());
        List<Integer> numberList = numbers.getNumbers();
        List<String> operatorList = operators.getOperators();

        int temp = 1;
        for (String operator : operatorList) {

            if(operator.equals("+")) {
                plus(numberList.get(temp));
            }
            if(operator.equals("-")) {
                minus(numberList.get(temp));
            }
            if(operator.equals("/")) {
                division(numberList.get(temp));
            }
            if(operator.equals("*")) {
                multiplication(numberList.get(temp));
            }
            temp++;
        }
    }

    public static void plus(int number) {
        result = result + number;
    }

    public static void multiplication(int number) {
        result = result * number;
    }

    public static void minus(int number) {
        result = result - number;
    }

    public static void division(int number) {
        result = result / number;
    }

    public static void setFirstNumber(Integer firstNumber) { result = firstNumber; }

    @Override
    public String toString() { return "result :" + result;}
}
