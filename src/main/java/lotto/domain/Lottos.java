package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int PRICE_PER_LOTTO = 1000;

    private List<Lotto> lottos;

    public Lottos(int money) {
        int count = money / PRICE_PER_LOTTO;
        checkValidation(count);
        this.lottos = IntStream.range(0, count).mapToObj(i -> new Lotto(new Numbers())).collect(Collectors.toList());
    }

    private void checkValidation(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("로또를 한 장 이상 구매하세요.");
        }
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Map<PrizeType, Integer> countMatch(Numbers prizeNumbers) {
        Map<PrizeType, Integer> prizeStat = new EnumMap<>(PrizeType.class);
        this.lottos.forEach(lotto -> {
            PrizeType prizeType = PrizeType.of(lotto.countMatch(prizeNumbers));
            prizeStat.put(prizeType, prizeStat.getOrDefault(prizeType, 0) + 1);
        });
        return prizeStat;
    }

    public BigDecimal getInvestment() {
        return new BigDecimal(this.lottos.size() * PRICE_PER_LOTTO);
    }
}
