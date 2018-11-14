package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRequest {
    private final Money money;
    private String[] manualLottoValues;

    public LottoRequest(Money won) {
        this(won, null);
    }

    public LottoRequest(Money money, String[] manualLottoValues) {
        this.money = money;
        this.manualLottoValues = manualLottoValues;
    }

    public Money getMoney() {
        return money;
    }

    public int getTotalGameTimes(int gameFee) {
        return money.getGameTImes(gameFee);
    }

    public int getManualGameTimes() {
        return manualLottoValues == null ? 0 : manualLottoValues.length;
    }

    public String[] getManualLottoValues() {
        return manualLottoValues;
    }
}
