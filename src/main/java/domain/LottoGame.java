package domain;

import java.math.RoundingMode;
import java.util.*;

import static domain.LottoMoney.MONEY_PER_GAME;

public class LottoGame {
    private final List<LottoNumbers> lottoNumbersList;

    public static LottoGame of(int money) {
        List<LottoNumbers> lottoNumbersList = generateLottoNumbersList(money);
        return new LottoGame(lottoNumbersList);
    }

    public LottoGame(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    private static List<LottoNumbers> generateLottoNumbersList(int money) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        int gameCount = money / MONEY_PER_GAME;

        for (int i = 0; i < gameCount; i++) {
            lottoNumbers.add(LottoNumbers.generatedAutoNumbers());
        }

        return lottoNumbers;
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }

    public WinningInfos getWinningInfos(LottoNumbers lottoWinningNumbers, Number bonusNumber) {
        WinningInfos winningInfos = WinningInfos.of();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            Rank rank = Rank.getRank(lottoNumbers, lottoWinningNumbers, bonusNumber);
            winningInfos.update(rank);
        }
        return winningInfos;
    }

    public double getBenefitRate(LottoMoney lottoMoney, WinningInfos winningInfos) {
        return winningInfos.getTotalWinningMoney()
                .divide(lottoMoney.getMoney(), 2, RoundingMode.DOWN)
                .doubleValue();
    }
}
