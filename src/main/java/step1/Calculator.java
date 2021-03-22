package step1;

public class Calculator {
    public static int add(Integer[] inputNumbers){
        int result = 0;
        for(Integer number : inputNumbers){
            result += number;
        }
        return result;
    }
}
