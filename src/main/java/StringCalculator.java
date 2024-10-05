import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class StringCalculator {
    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static int minus(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static int divide(int num1, int num2) {
        if(num2 == 0){
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return num1 / num2;
    }

    public static int calculate(int num1, int num2, String operator) {
        int res;
        switch(operator){
            case "+" :
                res = add(num1, num2);
                break;
            case "-" :
                res = minus(num1 ,num2);
                break;
            case "*":
                res = multiply(num1, num2);
                break;
            case "/":
                res = divide(num1, num2);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return res;
    }

    public static int calculateWithSplit(String[] split){
        Queue<String> ops = new LinkedList<>();
        Stack<Integer> results = new Stack<>();
        Queue<Integer> nums = new LinkedList<>();

        for(String s : split){
            if(List.of("+","-","*","/").contains(s)){
                ops.add(s);
            }
            else{
                nums.add(Integer.parseInt(s));
            }
        }

        while(!ops.isEmpty()){
            String op = ops.poll();
            if(results.isEmpty()){
                int num1 = nums.poll();
                int num2 = nums.poll();
                int result = calculate(num1, num2, op);
                results.push(result);
            }
            else{
                int num1 = results.pop();
                int num2 = nums.poll();
                int result = calculate(num1 ,num2, op);
                results.push(result);
            }
        }

        int res = results.pop();
        return res;
    }
}
