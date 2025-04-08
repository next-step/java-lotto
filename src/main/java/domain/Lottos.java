package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        this(new ArrayList<>());
    }

    Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lottos buy(int ticketCount) {
        for(int i = 0; i < ticketCount; i++){
            lottos.add(new Lotto());
        }
        return this;
    }

    public Lottos buy(String[] manualTicketNumbers) {
        for (String manualTicketNumber : manualTicketNumbers) {
            this.lottos.add(new Lotto(manualTicketNumber));
        }
        return this;
    }

    public Map<PrizeEnum, Integer> calculateWinResult(LottoNumbers winNumbers, int bonus) {

        Map<PrizeEnum, Integer> summaryMap = new HashMap<>();

        for (Lotto lotto : lottos) {
            PrizeEnum prizeEnum = PrizeEnum.of(lotto.getHitCount(winNumbers), lotto.hasBonusNumber(bonus));

            summaryMap.put(prizeEnum, summaryMap.getOrDefault(prizeEnum, 0) + 1);
        }
        return summaryMap;
    }

    public int size(){
        return lottos.size();
    }

    public List<String> convertToString() {
        return lottos.stream().map(Lotto::convertToString).collect(Collectors.toList());
    }
}
