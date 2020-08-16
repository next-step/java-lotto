package domain;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

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
            lottoNumbers.add(new LottoNumbers(LottoNumberPublisher.getShuffleSixLottoNumber()));
        }

        return lottoNumbers;
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }

    public WinningInfos getWinningInfos(LottoNumbers lottoWinningNumbers) {
        WinningInfos winningInfos = WinningInfos.of();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            Rank rank = Rank.getRank(lottoNumbers, lottoWinningNumbers);
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
