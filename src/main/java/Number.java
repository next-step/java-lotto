public class Number {
    private final int number;

    public Number(String number) {
        this.number = Integer.valueOf(number);
        if (this.number < 0) {
            throw new NumberFormatException("음수를 사용할 수 없습니다.");
        }
    }
}
