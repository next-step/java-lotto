package calc;

public class StringAddCalculator {

    public int add(String number) {
        if (number == null || number.equals("")) {
            return 0;
        }

        return Integer.parseInt(number);
    }
}
