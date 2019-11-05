package step2.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final int TICKET_MONEY = 1000;
    private static final int ADD = 1;
    private Map<PriceGroup, Integer> result;

    public LottoResult(WinningNumbers winningNumbers, List<LottoTicket> lottoTickets) {
        makeResult(winningNumbers, lottoTickets);
    }

    private void makeResult(WinningNumbers winningNumbers, List<LottoTicket> lottoTickets) {
        Map<PriceGroup, Integer> result = initResult();

        for (LottoTicket lottoTicket : lottoTickets) {
            int matchAmount = winningNumbers.getMatchAmount(lottoTicket);
            PriceGroup priceGroup = PriceGroup.findPriceByMatchAmount(matchAmount);
            result.put(priceGroup, result.get(priceGroup) + ADD);
        }
        this.result = result;
    }

    private Map<PriceGroup, Integer> initResult() {
        Map<PriceGroup, Integer> result = new HashMap<>();
        for (PriceGroup priceGroup : PriceGroup.values()) {
            result.put(priceGroup, 0);
        }
        return result;
    }

    public Map<PriceGroup, Integer> getResult() {
        return Collections.unmodifiableMap(this.result);
    }

    public Double getRate() {
        int size = (int) this.result.values().stream()
                .filter(amount -> amount != 0)
                .count();
        double purchaseMoney = TICKET_MONEY * size;

        long earnMoney = this.result.entrySet().stream()
                .mapToLong(this::sumPrice)
                .sum();

        return earnMoney / purchaseMoney;
    }

    private Long sumPrice(Map.Entry<PriceGroup, Integer> entry) {
        return entry.getKey().getPrice() * entry.getValue();
    }
}
