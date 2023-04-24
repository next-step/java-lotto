package calculator.Model;

public class Number {
    private int number;

    public Number(String input) {
        if (isNumeric(input)) {
            this.number = Integer.parseInt(input);
            return;
        }

        throw new IllegalArgumentException("숫자가 아닙니다.");
    }

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public int currentNumber() {
        return number;
    }

    public void changeNumber(int number) {
        this.number = number;
    }

}
