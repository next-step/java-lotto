import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {

    public static final int ZERO = 0;
    public static final List<String> OPSLIST = Arrays.asList("+", "*", "/", "-");

    public static int doCalculate(String inputValue){

        String[] strList = splitText(inputValue);
        ArrayList<Integer> valueList = filterValue(strList);
        ArrayList<String> opsList = filterOps(strList);

        if(valueList.size()<=0){
            throw new IllegalArgumentException("연산 할 값이 없습니다.");
        }

        if(valueList.size()!=opsList.size()+1){
            throw new IllegalArgumentException("계산식이 잘못 되였습니다.");
        }

        // 첫번째 값 -> Result에 대입하기
        int resultValue = valueList.get(0);

        /**
         * 계산 공식 돌리기
         */







        return ZERO;
    }

    public static ArrayList<String> filterOps(String[] inputList){
        ArrayList<String> opsList = new ArrayList<String>();

        IntStream.range(0, inputList.length).forEach(idx -> {
            if(idx%2!=0 && checkOps(inputList[idx])){
                opsList.add(inputList[idx]);
            }
        });

        return opsList;
    }

    private static boolean checkOps(String text) {

        try {
            return OPSLIST.stream().anyMatch(p -> p.equals(text));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("연산자가 아닙니다.");
        }
    }


    public static ArrayList<Integer> filterValue(String[] inputList){
        ArrayList<Integer> valueList = new ArrayList<Integer>();

        IntStream.range(0, inputList.length).forEach(idx -> {
            if(idx%2==0){
                valueList.add(convertNum(inputList[idx]));
            }
        });

        return valueList;
    }

    private static int convertNum(String text) {
        try {
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public static String[] splitText(String text){
        return text.split(" ");
    }

    public static int add(int number1, int number2){
        return number1 + number2;
    }

    public static int subtract(int number1, int number2){
        return number1 - number2;
    }

    public static int multiply(int number1, int number2){
        return number1 * number2;
    }

    public static int divide(int number1, int number2){
        return number1 / number2;
    }

    public static boolean checkDivideValue(int number1, int number2){
        if(number1 % number2!=0){
            return false;
        }
        return true;
    }

    public static boolean isBlank(String input){
        return " ".equals(input);
    }



}
