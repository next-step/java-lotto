package lotto.domain;

public class Count implements Comparable<Count>{

    private int count;

    public Count(int count) {
        this(count, null);
    }

    public Count(int count, Budget budget) {
        validPositiveValue(count);
        validEnableCount(count, budget);
        this.count = count;
    }

    private void validEnableCount(int count, Budget budget) {
        if(budget == null) {
            return;
        }
        if(!budget.isEnoughToPay(Price.LOTTO, count)){
            throw new IllegalArgumentException("구매 가능 수량을 초과했습니다: " + count);
        }
    }

    private void validPositiveValue(int count) {
        if (count < 0)
            throw new IllegalArgumentException("양수 값만 입력할 수 있습니다: " + count);
    }

    public int getCount() {
        return count;
    }

    public boolean isPositive() {
        return count > 0;
    }

    public Count decrease() {
        return new Count(count - 1);
    }

    @Override
    public int compareTo(Count that) {
        return this.count - that.count;
    }
}
