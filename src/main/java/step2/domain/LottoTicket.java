package step2.domain;

import step2.domain.enums.WinnerPriceType;
import step2.domain.strategy.LottoNumberGeneratorStrategy;

import java.util.*;

public class LottoTicket {
    private static final int INIT_COUNT = 1;
    private List<Lotto> lottos;
    private Map<Integer, Integer> winLottoCountByMatchCount;
    private LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy;

    public LottoTicket(List<Lotto> lottos, LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        this.lottos = lottos;
        this.winLottoCountByMatchCount = new HashMap<>();
        this.lottoNumberGeneratorStrategy = lottoNumberGeneratorStrategy;
        generateLotto();
    }

    private void generateLotto() {
        lottos.forEach(lotto -> lotto.generateNumber(lottoNumberGeneratorStrategy));
    }

    public Map<Integer, Integer> getWinLottoCount(Optional<WinningNumbers> winningNumbers) {
        lottos.forEach(lotto -> {
            int matchCount = lotto.getMatchCount(winningNumbers);
            if (matchCount > 2)
                addWinCount(matchCount);
        });
        return winLottoCountByMatchCount;
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (WinnerPriceType priceEnum : WinnerPriceType.values()) {
            totalPrice += priceEnum.calculateulatePrice(winLottoCountByMatchCount.getOrDefault(priceEnum.matchCount, 0));
        }
        return totalPrice;
    }

    private void addWinCount(int matchCount) {
        if (winLottoCountByMatchCount.containsKey(matchCount)) {
            winLottoCountByMatchCount.put(matchCount, winLottoCountByMatchCount.get(matchCount) + 1);
        }
        winLottoCountByMatchCount.put(matchCount, INIT_COUNT);
    }

    public float calculateWinnerRatio(int lottoAmount, int totalPrice) {
       return totalPrice == 0 ? 0 : (float) totalPrice / (float) (lottoAmount * 1000);
    }

    public List<Lotto> getLottos() {
        List<Lotto> copyArrayList = new ArrayList<>(lottos);
        return copyArrayList;
    }
}
