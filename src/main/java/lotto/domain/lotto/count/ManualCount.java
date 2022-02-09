package lotto.domain.lotto.count;

public class ManualCount {

    private final Count count;

    public ManualCount(String count, Count maxCount) {
        this(parseToInteger(count), maxCount);
    }

    private static Integer parseToInteger(String value) {
        if(!value.matches("[-]?[0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 들어올 수 있습니다.");
        }
        return Integer.parseInt(value);
    }

    public ManualCount(int count, Count maxCount) {
        validManualCount(count, maxCount);
        this.count = new Count(count);
    }

    private void validManualCount(int count, Count maxCount) {
        if(count > maxCount.getValue()) {
            throw new IllegalArgumentException("[ERROR] "+maxCount.getValue()+"개를 초과할 수 없습니다.");
        }
    }

    public Integer getCountValue() {
        return count.getValue();
    }
}
