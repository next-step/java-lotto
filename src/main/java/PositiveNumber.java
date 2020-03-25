public class PositiveNumber {
    private int number;

    public PositiveNumber(int number) {
        validateNegative(number);
        this.number = number;
    }

    public int addInt(int number){
        return this.number + number;
    }

    private int validateNegative(int number) {
        if (hasNegative(number)) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private boolean hasNegative(int number) {
        return number < 0;
    }
}
