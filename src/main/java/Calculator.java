import java.util.List;

public class Calculator {

    public static int returnCalculateResult(String inputString) {
        List<String> splitStrings = SplitString.splitInputString(inputString);

        return operateString(splitStrings);
    }

    public static int operateString(List<String> splitStrings){
        int result = Integer.parseInt(splitStrings.get(0));

        for(int i=1; i<splitStrings.size(); i+=2){
            result = Calculator.operate(splitStrings.get(i), result, Integer.parseInt(splitStrings.get(i +1)));
        }

        return result;
    }

    public static int operate(String operator, int number1, int number2) {
        return OperatorMapping.returnOperation(operator).calculate(number1, number2);
    }

}
