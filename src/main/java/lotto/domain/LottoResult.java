package lotto.domain;

import lotto.util.LottoTicketUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LottoResult {
    private final Map<LottoPrize, Integer> lottoResult;

    public LottoResult() {
        lottoResult = init();
    }

    private Map init() {
        Map<LottoPrize, Integer> lottoResult = new HashMap<>();
        lottoResult.put(LottoPrize.FIRST, 0);
        lottoResult.put(LottoPrize.SECOND, 0);
        lottoResult.put(LottoPrize.THIRD, 0);
        lottoResult.put(LottoPrize.FOURTH, 0);
        lottoResult.put(LottoPrize.NONE, 0);
        return lottoResult;
    }

    public int prizeCount(LottoPrize prize) {
        return lottoResult.get(prize);
    }

    public void increase(LottoPrize prize) {
        lottoResult.put(prize, lottoResult.get(prize) + 1);
    }

    public double average() {
        return totalPrice() / totalTicketCost();
    }

    private int totalPrice() {
        int sum = 0;
        for (int i = 0; i < LottoPrize.values().length; i++) {
            LottoPrize prize = LottoPrize.values()[i];
            sum += lottoResult.get(prize) * prize.getPrice();
        }
        return sum;
    }

    private int totalTicketCost() {
        int count = 0;
        Iterator<Map.Entry<LottoPrize, Integer>> iterator = lottoResult.entrySet().iterator();
        while (iterator.hasNext()) {
            count += iterator.next().getValue();
        }
        return count * LottoTicketUtils.TICKET_PRICE;
    }
}
