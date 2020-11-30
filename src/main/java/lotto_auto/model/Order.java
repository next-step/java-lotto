package lotto_auto.model;

import lotto_auto.ErrorMessage;

import java.util.List;

public class Order {

    private final List<LottoNumbers> manualLottoNumbers;
    private final int auto;

    public Order(List<LottoNumbers> manualLottoNumbers, Money money) {
        throwIfManualLottoNumberIsNull(manualLottoNumbers);
        int ticketCount = money.getMoney() / LottoTicket.PRICE;
        this.manualLottoNumbers = manualLottoNumbers;
        this.auto = ticketCount - manualLottoNumbers.size();

    }

    private void throwIfManualLottoNumberIsNull(List<LottoNumbers> manualLottoNumbers) {
        if (manualLottoNumbers == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_ORDER);
        }
    }

    public List<LottoNumbers> getManualNumbers() {
        return this.manualLottoNumbers;
    }

    public int getAutoCount() {
        return this.auto;
    }

    public int getManualCount() {
        return this.manualLottoNumbers.size();
    }
}
