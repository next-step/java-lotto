public class Number {

    private final int number;

    public Number(final String number) {
        this.number = Integer.parseInt(number);
    }

    public Number(final int number) {
        this.number = number;
    }

    public Number add(Number operand) {
        return new Number(number + operand.getNumber());
    }

    public int getNumber() {
        return number;
    }
}
