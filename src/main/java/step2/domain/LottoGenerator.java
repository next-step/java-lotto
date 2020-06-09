package step2.domain;

import step2.domain.enums.WinnerPriceEnum;
import step2.domain.strategy.LottoGeneratorStrategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private LottoTicket lottoTicket;

    public LottoGenerator(int lottoAmount, LottoGeneratorStrategy lottoGeneratorStrategy) {
        this.lottoTicket = new LottoTicket(Stream.generate(() -> new Lotto(lottoGeneratorStrategy))
                .limit(lottoAmount)
                .collect(Collectors.toList()));
    }

    public void generate() {
        lottoTicket.generateLotto();
    }

    public void calcLottoWinCount(List<String> winningNumber) {
        lottoTicket.calcWinLottoCountMap(winningNumber);
    }

    public int calcTotalPrice() {
        int totalPrice = 0;
        for (WinnerPriceEnum priceEnum : WinnerPriceEnum.values()) {
            totalPrice += priceEnum.calculatePrice(getLottoWinCount().getOrDefault(priceEnum.matchCount, 0));
        }
        return totalPrice;
    }

    public String calcWinnerRatio(int lottoAmount, int totalPrice) {
        if (totalPrice > 0)
            return String.format("%.2f", (float) totalPrice / (float) (lottoAmount * 1000));
        return "0";
    }

    public Map<Integer, Integer> getLottoWinCount() {
        return lottoTicket.getWinLottoCountMap();
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }
}
