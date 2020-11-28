package lotto_auto.model;

import lotto_auto.ErrorMessage;

import java.util.List;

public class Order {

    private final List<LottoNumbers> manualLottoNumbers;
    private final int auto;

    public Order(List<LottoNumbers> manualLottoNumbers, int auto) {
        throwIfManualLottoNumberIsNull(manualLottoNumbers);
        this.manualLottoNumbers = manualLottoNumbers;
        this.auto = auto;
    }

    private void throwIfManualLottoNumberIsNull(List<LottoNumbers> manualLottoNumbers) {
        if (manualLottoNumbers == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_ORDER);
        }
    }

    public List<LottoNumbers> getManualNumbers() {
        return this.manualLottoNumbers;
    }

    public int getAuto() {
        return this.auto;
    }
}
