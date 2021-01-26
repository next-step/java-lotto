package calculator;

public class StringCalculator {

    public static void main(String[] args) {

    }

    public int add (String text) {
        if (InputValidator.checkIsNullOrIsEmpty(text)) {
            return 0;
        }

        if (text.length() == 1) {
          return Integer.parseInt(text);
        }

        String [] inputs = text.split(",");
        int res = 0;
        for (String input : inputs) {
            res += Integer.parseInt(input);
        }



        return res;
    }

}
