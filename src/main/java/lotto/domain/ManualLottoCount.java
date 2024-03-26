package lotto.domain;

public class ManualLottoCount {
    private Integer count;

    public ManualLottoCount(Integer count) {
        validateIfNotNull(count);
        this.count = count;
    }

    private void validateIfNotNull(Integer count){
        if(count == null){
            throw new IllegalArgumentException();
        }
    }
}
