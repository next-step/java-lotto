package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private final LottoCollection lottoCollection;
    private final LottoResult lottoResult;
    private final int totalMoney;

    public LottoService(int totalMoney, RandomGenerator random) {
        this.totalMoney = totalMoney;
        this.lottoResult = new LottoResult();
        this.lottoCollection = new LottoCollection(totalMoney / LOTTO_PRICE, random);
    }

    public void drawLotto(String text) {
        lottoResult.addRanks(lottoCollection.getLottoRanks(
                new LottoNumbers(
                    Arrays.stream(text.split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                )
            )
        );
        lottoResult.calculateTotalWinningMoney();
        lottoResult.calculateReturnRate(totalMoney);
    }

    public Map<LottoRank, Integer> totalWinningStatistics() {
        return lottoResult.totalWinningStatistics();
    }

    public double returnRate() {
        return lottoResult.returnRate();
    }

    public List<LottoNumbers> getLottoNumberList() {
        return lottoCollection.getLottoNumberList();
    }
}
