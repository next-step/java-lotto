import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final String FORMULA_REGEX = "^[0-9+\\-*/\\s]+$\n";
    private List<BasicOperator> operations = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();


    public static int add(int x, int y) {
        return x+y;
    }

    public static int subtraction(int x, int y) {
        return x-y;
    }

    public static int multiplication(int x, int y) {
        return x*y;
    }

    public static int division(int x, int y) {
        return x/y;
    }

    public static int calculate(String formula) {
        validateFormula(formula);
        String[] nums = formula.split(" ");

        int result = 0;

        for (int i = 0; i < nums.length; i++) {


            if(nums[i].equals("+")){

            }else if(nums[i].equals("-")){

            }else if(nums[i].equals("*")){

            }else if(nums[i].equals("/")){

            }

        }

        return result;
    }

    private static void validateFormula(String formula){
        if(!formula.matches(FORMULA_REGEX)){
            throw new IllegalArgumentException("숫자와 사칙연산 기호만이 입력 되어야 합니다.");
        }
    }
}
