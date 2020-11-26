package lotto_auto.model;

import lotto_auto.ErrorMessage;

import java.util.List;

public class Order {

    private final List<LottoNumbers> manualLottoNumbers;
    private final int total;
    private final int manual;
    private final int auto;

    public Order(int total, int manual, List<LottoNumbers> manualLottoNumbers, int auto) {
        throwIfInvalidLottoOrder(total, manual, auto);
        throwIfManualLottoNumberIsNull(manualLottoNumbers);
        this.total = total;
        this.manual = manual;
        this.manualLottoNumbers = manualLottoNumbers;
        this.auto = auto;
    }

    private void throwIfInvalidLottoOrder(int total, int manual, int auto) {
        if (total != manual + auto) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_ORDER);
        }
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
