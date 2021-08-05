package calculator;

public class Calculator {
    public int addEachAll(int[] elements) {
        int result = 0;
        for (int element : elements) {
            result += element;
        }
        return result;
    }
}
