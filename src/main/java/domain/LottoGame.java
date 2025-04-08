package domain;

import java.util.List;
import java.util.Map;

public class LottoGame {

    public static final int TICKET_PRICE = 1_000;

    private final Lottos autoLottos;
    private final Lottos manualLottos;

    public LottoGame() {
        this.autoLottos = new Lottos();
        this.manualLottos = new Lottos();
    }

    public LottoGame buy(int ticketCount) {
        autoLottos.buy(ticketCount);
        return this;
    }

    public LottoGame buy(String[] manualTicketNumbers) {
        manualLottos.buy(manualTicketNumbers);
        return this;
    }

    public LottoGame buy(int ticketCount, String[] manualTicketNumbers) {
        this.buy(ticketCount);
        this.buy(manualTicketNumbers);
        return this;
    }

    public Map<PrizeEnum, Integer> calculateWinResult(LottoNumbers winNumbers, int bonus) {
        Map<PrizeEnum, Integer> resultMap = autoLottos.calculateWinResult(winNumbers, bonus);
        resultMap.putAll(manualLottos.calculateWinResult(winNumbers, bonus));
        return resultMap;
    }

    public int getAutoLottosSize() {
        return autoLottos.size();
    }

    public int getManualLottosSize() {
        return manualLottos.size();
    }

    public List<String> convertToString() {
        return autoLottos.convertToString();
    }
}
