package domain;

import java.util.*;

public class Lottos {

    private final List<Lotto> autoLottos;
    private final List<Lotto> manaulLottos;

    public Lottos() {
        this(new ArrayList<>());
    }

    Lottos(List<Lotto> lottos) {
        this(lottos, new ArrayList<>());
    }

    Lottos(List<Lotto> lottos, List<Lotto> manualLottos) {
        this.autoLottos = lottos;
        this.manaulLottos = manualLottos;
    }

    public List<Lotto> getAutoLottos() {
        return autoLottos;
    }

    public List<Lotto> getManualLottos() {
        return manaulLottos;
    }

    public Lottos buy(int ticketCount) {
        return buy(ticketCount, new String[]{});
    }

    public Lottos buy(int ticketCount, String[] manualTicketNumbers) {
        for (int i = 0; i < ticketCount - manualTicketNumbers.length; i++) {
            this.autoLottos.add(new Lotto());
        }
        for (String manualTicketNumber : manualTicketNumbers) {
            this.manaulLottos.add(new Lotto(manualTicketNumber));
        }
        return this;
    }

    public Map<PrizeEnum, Integer> calculateWinResult(LottoNumbers winNumbers, int bonus) {

        Map<PrizeEnum, Integer> summaryMap = new HashMap<>();

        List<Lotto> lottos = new ArrayList<>() {{
            addAll(autoLottos);
            addAll(manaulLottos);
        }};

        for (Lotto lotto : lottos) {

            PrizeEnum prizeEnum = PrizeEnum.of(lotto.getHitCount(winNumbers), lotto.hasBonusNumber(bonus));

            summaryMap.put(prizeEnum, summaryMap.getOrDefault(prizeEnum, 0) + 1);
        }
        return summaryMap;
    }
}
