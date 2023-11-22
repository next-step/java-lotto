package lotto.domain;

import java.util.Objects;

public class ManualLottoCount {

    private final int value;

    public ManualLottoCount(String manualLottoCount) {
        int lottoCount = getLottoCount(manualLottoCount);
        validateLottoRange(lottoCount);
        this.value = lottoCount;
    }

    private void validateLottoRange(int lottoCount) {
        if (lottoCount <= 0) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 0보다 작을 수 없습니다.");
        }
    }

    private int getLottoCount(String manualLottoCount) {
        int lottoCount;
        try{
            lottoCount = Integer.parseInt(manualLottoCount);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 숫자여야 합니다.");
        }
        return lottoCount;
    }

    public int findLottoCount() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManualLottoCount that = (ManualLottoCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
