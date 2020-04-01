package lotto.domain;

import lotto.util.LottoTicketUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoPrize, Integer> lottoResult;
    private final int ZERO = 0;

    public LottoResult() {
        lottoResult = init();
    }

    private Map init() {
        Map<LottoPrize, Integer> lottoResult = new HashMap<>();
        Arrays.stream(LottoPrize.values())
                .forEach(lottoPrize ->
                        lottoResult.put(lottoPrize, ZERO)
                );
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

    private double totalPrice() {
        int sum = 0;
        for (LottoPrize prize : LottoPrize.values()) {
            sum += prize.getPrice() * lottoResult.get(prize);
        }
        return sum;
    }

    private double totalTicketCost() {
        int totalTicketCount = 0;
        for (int ticketCount : lottoResult.values()) {
            totalTicketCount += ticketCount;
        }
        return totalTicketCount * LottoTicketUtils.TICKET_PRICE;
    }
}
