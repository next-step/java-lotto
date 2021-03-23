package step1.number;

public final class Number {

    private final int number;

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    public Number(int number) {
        this.number = number;
    }

}
