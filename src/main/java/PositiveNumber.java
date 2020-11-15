public class PositiveNumber {

    private final int positiveNum;

    public PositiveNumber(String number) {
        int positiveNum;
        try {
            positiveNum = Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("잘못된 입력 입니다.");
        }
        if (positiveNum < 0) {
            throw new IllegalArgumentException("음수는 입력 불가 입니다.");
        }
        this.positiveNum = positiveNum;
    }

    public int getPositiveNumber() {
        return positiveNum;
    }
}
