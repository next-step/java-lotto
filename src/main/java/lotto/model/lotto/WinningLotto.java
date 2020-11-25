package lotto.model.lotto;

import lotto.model.Hit;
import lotto.strategy.DrawingStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

public class WinningLotto extends Lotto {
    private final static String CONTAIN_BONUS_ERROR_MESSAGE = "당첨 번호에는 보너스 볼 번호가 들어갈 수 없습니다.";
    private LottoNumber bonus;

    public WinningLotto(LottoNumber bonus, DrawingStrategy drawingStrategy) {
        super(drawingStrategy);
        if (numbers.contain(bonus)) {
            throw new IllegalArgumentException(CONTAIN_BONUS_ERROR_MESSAGE);
        }
        this.bonus = bonus;
    }


    public Map<Hit, Integer> getResult(List<LottoTicket> lottoes) {
        Map<Hit, Integer> hits = Hit.getHits();

        lottoes.stream()
                .map(lotto -> getMatchingNumberCount(lotto, bonus))
                .map(matchedNumber -> Hit.findByNumbers(matchedNumber, bonus))
                .forEach(hit -> hits.computeIfPresent(hit, (Hit key, Integer value) -> ++value));

        return hits;
    }


    public double getEarningRate(int amount, List<LottoTicket> numbers) {
        long totalReword = getResult(numbers).entrySet().stream()
                .mapToLong(this::calculateReword)
                .sum();

        BigDecimal safeReword = BigDecimal.valueOf((double) totalReword);
        BigDecimal safeAmount = BigDecimal.valueOf(amount);

        return safeReword.divide(safeAmount, 2, RoundingMode.FLOOR)
                .doubleValue();
    }


    private long calculateReword(Map.Entry<Hit, Integer> hits) {
        return hits.getKey().calculateReword(hits.getValue());
    }

    @Override
    public LottoTicket getLottoTicket() {
        return null;
    }
}

