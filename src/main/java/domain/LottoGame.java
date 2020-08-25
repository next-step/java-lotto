package domain;

import java.math.RoundingMode;
import java.util.*;

import static domain.LottoMoney.MONEY_PER_GAME;

public class LottoGame {
    private final List<Lotto> lottoList;

    public static LottoGame of(int money) {
        List<Lotto> lottoList = generateLottoNumbersList(money);
        return new LottoGame(lottoList);
    }

    public LottoGame(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    private static List<Lotto> generateLottoNumbersList(int money) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        int gameCount = money / MONEY_PER_GAME;

        for (int i = 0; i < gameCount; i++) {
            lottoNumbers.add(Lotto.generatedAutoNumbers());
        }

        return lottoNumbers;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public WinningInfos getWinningInfos(Lotto lottoWinningNumbers, Number bonusNumber) {
        WinningInfos winningInfos = WinningInfos.of();
        for (Lotto lotto : lottoList) {
            Rank rank = Rank.getRank(lotto, lottoWinningNumbers, bonusNumber);
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
