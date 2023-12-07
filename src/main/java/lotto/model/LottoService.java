package lotto.model;

import java.util.List;
import java.util.Map;

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

    public LottoService(int totalMoney, RandomGenerator random, List<LottoNumbers> lottoNumbers) {
        this.totalMoney = totalMoney;
        this.lottoResult = new LottoResult();
        this.lottoCollection = new LottoCollection(
            (totalMoney - lottoNumbers.size() * LOTTO_PRICE) / LOTTO_PRICE, random, lottoNumbers);
    }

    public void drawLotto(List<Integer> winningNumbers, int bonusNumber) {
        lottoResult.addRanks(
            lottoCollection.getLottoRanks(new WinningNumbers(winningNumbers, bonusNumber)));
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
