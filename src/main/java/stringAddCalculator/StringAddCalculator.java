package stringAddCalculator;

public class StringAddCalculator {

    public int add(String inputText) {
        if (inputText == null || inputText.isBlank()) {
            return 0;
        }

        int result = 0;
        String[] StringNumbers = inputText.split(",");
        for (String number : StringNumbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
