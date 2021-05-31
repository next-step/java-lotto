package lottery.domain;

public class GenerateCount {

    public static final int MINIMUM_GENERATE_COUNT = 1;

    private final int count;

    public GenerateCount(int count) {
        validateGenerateCount(count);

        this.count = count;
    }

    private void validateGenerateCount(int count) {
        if (count < MINIMUM_GENERATE_COUNT) {
            throw new IllegalArgumentException("로또 생성 개수는 1개 이상이어야 합니다.");
        }
    }

    public int count() {
        return count;
    }
}
