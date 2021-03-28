package splitandsum;

public class Number {
    private int number;

    public Number(String number) {
        this.number = ValidationNumber.isNegativeNum(Integer.parseInt(number));
    }

    public int getNumber() {
        return number;
    }
}
