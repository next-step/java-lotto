package lotto.model;

public class ManualCount {
    private final int count;

    public ManualCount(int count) {
        validateMinus(count);
        this.count = count;
    }

    private void validateMinus(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("수동으로 구매할 로또는 음수일 수 없습니다.");
        }
    }

    public int count(){
        return this.count;
    }
}
