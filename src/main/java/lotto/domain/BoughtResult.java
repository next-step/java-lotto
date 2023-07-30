package lotto.domain;

public class BoughtResult {

    private final Money change;
    private final BoughtLottos boughtLottos;

    public BoughtResult(Money change, BoughtLottos boughtLottos) {
        this.change = change;
        this.boughtLottos = boughtLottos;
    }

    public Money getChange() {
        return change;
    }

    public BoughtLottos getBoughtLottos() {
        return boughtLottos;
    }
}
