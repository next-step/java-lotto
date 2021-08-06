package app.domain;

public class ManualCount {
    private int count;

    private ManualCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        }
        this.count = count;
    }

    public static ManualCount of(int number) {
        return new ManualCount(number);
    }

    public static ManualCount of(String number) {
        return new ManualCount(Integer.valueOf(number));
    }

    public int getCount() {
        return count;
    }
}
