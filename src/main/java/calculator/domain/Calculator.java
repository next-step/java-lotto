package calculator.domain;

public class Calculator {
    public int addEachAll(String[] elements) {
        int result = 0;
        for (String element : elements) {
            result += Integer.parseInt(element);
        }
        return result;
    }
}
