public class Number {

    private final Integer number;

    public Number(Integer number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public int get() {
        return number;
    }
}
