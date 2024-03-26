package lotto.domain;

public class ManualLottoCount {
    private final Integer count;

    public ManualLottoCount(Integer count) {
        validateIfNotNull(count);
        this.count = count;
    }

    public void validateIfLargerThanWholeCount(Cash cash){
        int amount = cash.getAmount();
        if(amount < this.count) throw new IllegalArgumentException();
    }

    private void validateIfNotNull(Integer count){
        if(count == null){
            throw new IllegalArgumentException();
        }
    }
}
