package autoLotto;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class LottoResult {
    private final Map<LottoPrize, Integer> result;
    private int budget;
    private int purchasedLottoCount;
    private final int LOTTO_PRICE = 1_000;

    public LottoResult(int budget) {
        result = new EnumMap<>(LottoPrize.class);
        Stream.of(LottoPrize.values()).forEach(type -> result.put(type, 0));
        this.budget = budget;
        this.purchasedLottoCount = budget/LOTTO_PRICE;
    }

    public int getPurchasedLottoCount() {
        return purchasedLottoCount;
    }

    public Integer getResult(LottoPrize lottoPrize) {
        return result.get(lottoPrize);
    }

    public void addMatchCount(LottoPrize prize) {
        result.merge(prize, 1, Integer::sum);
    }

    private double calculateRor(long profit) {
        return profit/budget;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();

        AtomicLong profit = new AtomicLong();
        result.entrySet().stream()
              .filter(entry -> !entry.getKey().equals(LottoPrize.MISS))
              .map(entry -> formatLottoPrize(entry, profit))
              .forEach(resultString::append);

        double ror = calculateRor(profit.get());
        String explanation = "손해";

        if (ror > 1) {
            explanation = "이득";
        }

        String rorResult = String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", ror, explanation);
        resultString.append(rorResult);

        return resultString.toString();
    }

    private String formatLottoPrize(Map.Entry<LottoPrize, Integer> entry, AtomicLong profit) {
        LottoPrize lottoPrize = entry.getKey();
        int quantity = entry.getValue();

        profit.addAndGet(lottoPrize.getPrize() * quantity);

        return String.format("%s - %d개\n", lottoPrize, quantity);
    }
}
