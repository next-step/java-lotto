package lotto.domain.lotto.count;

public class ManualCount {

    private final Count count;

    public ManualCount(String count, Count totalCount) {
        this(parseToInteger(count), totalCount);
    }

    private static Integer parseToInteger(String value) {
        if(!value.matches("[-]?[0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 들어올 수 있습니다.");
        }
        return Integer.parseInt(value);
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
