import model.Lotto;
import model.LottoNumberStrategy;
import model.LottoStatistics;
import model.Prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoMachine {
    public static final int PRICE_OF_A_LOTTO = 1000;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int totalPrice;
    private int numberOfLotto;
    private LottoNumberStrategy lottoNumberStrategy;

    public LottoMachine(
            List<Integer> winningNumbers,
            int totalPrice,
            LottoNumberStrategy lottoNumberStrategy
    ) {

        this.winningNumbers = winningNumbers;
        this.totalPrice = totalPrice;
        this.lottoNumberStrategy = lottoNumberStrategy;
        this.numberOfLotto = totalPrice / PRICE_OF_A_LOTTO;
        this.lottos = lottoNumberStrategy.create(this.numberOfLotto).stream()
                .map(Lotto::new)
                .peek(it -> it.calPrize(winningNumbers))
                .collect(Collectors.toList());
        this.lottos.forEach(it -> it.calPrize(winningNumbers));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

    public LottoNumberStrategy getLottoNumberStrategy() {
        return lottoNumberStrategy;
    }

    public LottoStatistics getStatistics() {
        List<Prize> prizes = getPrizes(this.lottos);
        Map<Integer, Integer> counts = getCounts(prizes);
        LottoStatistics lottoStatistics = new LottoStatistics(counts, this.totalPrice);
        return lottoStatistics;
    }

    private Map<Integer, Integer> getCounts(List<Prize> prizes) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(3, 0);
        counts.put(4, 0);
        counts.put(5, 0);
        counts.put(6, 0);
        for (Prize prize : prizes) {
            counts.put(prize.getMatched(), counts.get(prize.getMatched()) + 1);
        }
        return counts;
    }

    private List<Prize> getPrizes(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getPrize)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
