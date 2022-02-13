package lotto.domain.lotto.count;

public class ManualCount {

    private final Count count;

    public ManualCount(Count count, Count totalCount) {
        this(count.getValue(), totalCount);
    }

    public ManualCount(int count, Count totalCount) {
        validManualCount(count, totalCount);
        this.count = new Count(count);
    }

    private void validManualCount(int count, Count totalCount) {
        if(count > totalCount.getValue()) {
            throw new IllegalArgumentException("[ERROR] "+totalCount.getValue()+"개를 초과할 수 없습니다.");
        }
    }

    public Integer getCountValue() {
        return count.getValue();
    }
}
