package step1;

public class StringCalculator {

    public int calculate(String inputString) {
        if (inputString == null || "".equals(inputString)) {
            return 0;
        }
        return Integer.parseInt(inputString);
    }
}
