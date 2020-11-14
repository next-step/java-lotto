public class Number {

    private final int num;

    public Number(String n) {
        int num = Integer.parseInt(n);
        if (num < 0) {
            throw new RuntimeException("");
        }
        this.num = num;
    }

    public int number() {
        return num;
    }
}
