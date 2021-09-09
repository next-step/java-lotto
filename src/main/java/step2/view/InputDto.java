package step2.view;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.Price;
import step2.domain.statistics.Amount;

import java.util.List;

public class InputDto {
    private final Price price;
    private final Amount manualAmount;
    private final List<Lotto> manualLottoList;

    public InputDto(Price price, Amount manualAmount, List<Lotto> manualLottoList) {
        this.price = price;
        this.manualAmount = manualAmount;
        this.manualLottoList = manualLottoList;
    }

    public Amount getManualAmount() {
        return this.manualAmount;
    }

    public Price getPrice() {
        return price;
    }

    public List<Lotto> getManualLottoList() {
        return this.manualLottoList;
    }
}
