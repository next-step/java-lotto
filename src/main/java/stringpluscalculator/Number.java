package stringpluscalculator;

public class Number {
    static String checkRegex = "^[0-9]\\d*";
    static int number;
    public Number(String number) {
        validNumber(number);
        this.number = Integer.parseInt(number);
    }

    protected void validNumber(String str) {
        if(!str.matches(checkRegex)) {
            throw new RuntimeException();
        }
    }
}