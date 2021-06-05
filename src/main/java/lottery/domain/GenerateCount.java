package lottery.domain;

public class GenerateCount {

    public static final int MINIMUM = 1;

    private final int count;

    public GenerateCount(int count) {
        validateGenerateCount(count);

        this.count = count;
    }

    private void validateGenerateCount(int count) {
        if (count < MINIMUM) {
            throw new IllegalArgumentException("로또 생성 개수는 " + MINIMUM + "개 이상이어야 합니다.");
        }
    }

    public int count() {
        return count;
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
