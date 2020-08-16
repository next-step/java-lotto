package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static domain.LottoMoney.MONEY_PER_GAME;

public class LottoGame {
    private final List<LottoNumbers> lottoNumbersList;
    private final LottoWinningNumbers lottoWinningNumbers;

    public static LottoGame of(int money, List<Number> winningNumbers) {
        List<LottoNumbers> lottoNumbersList = generateLottoNumbersList(money);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers);
        return new LottoGame(lottoNumbersList, lottoWinningNumbers);
    }

    public LottoGame(List<LottoNumbers> lottoNumbersList, LottoWinningNumbers lottoWinningNumbers) {
        this.lottoNumbersList = lottoNumbersList;
        this.lottoWinningNumbers = lottoWinningNumbers;
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

    public WinningInfos getWinningInfos() {
        WinningInfos winningInfos = WinningInfos.of();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            LottoWinningType winningType = lottoWinningNumbers.getWinningType(lottoNumbers);
            winningInfos.add(winningType);
        }
        return winningInfos;
    }

    public double getBenefitRate(LottoMoney lottoMoney, WinningInfos winningInfos) {
        if (lottoMoney.getMoney().equals(BigDecimal.ZERO)) {
            return 0.0;
        }
        return winningInfos.getTotalWinningMoney().divide(lottoMoney.getMoney(), 2, RoundingMode.DOWN).doubleValue();
    }
}
