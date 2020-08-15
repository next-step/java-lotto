package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static domain.LottoMoney.MONEY_PER_GAME;

public class LottoGame {
    private final List<LottoNumbers> lottoNumbersList;
    private final WinningInfos winningInfos;
    private final double benefitRate;

    public static LottoGame of(int money, List<Integer> winningNumbers) {
        LottoMoney lottoMoney = new LottoMoney(money);
        List<LottoNumbers> lottoNumbersList = generateLottoNumbersList(lottoMoney.getMoney());
        List<Number> collect = winningNumbers.stream().map(Number::new).collect(Collectors.toList());
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(collect);
        WinningInfos winningInfos = generateLottoWinningInfos(lottoNumbersList, lottoWinningNumbers);
        double benefitRate = generateBenefitRate(lottoMoney, winningInfos);

        return new LottoGame(lottoNumbersList, winningInfos, benefitRate);
    }

    private static double generateBenefitRate(LottoMoney lottoMoney, WinningInfos winningInfos) {
        if (lottoMoney.getMoney().equals(BigDecimal.ZERO)) {
            return 0.0;
        }
        return winningInfos.getTotalWinningMoney().divide(lottoMoney.getMoney(), 2, RoundingMode.DOWN).doubleValue();
    }

    public LottoGame(List<LottoNumbers> lottoNumbersList, WinningInfos winningInfos, double benefitRate) {
        this.lottoNumbersList = lottoNumbersList;
        this.winningInfos = winningInfos;
        this.benefitRate = benefitRate;
    }

    private static List<LottoNumbers> generateLottoNumbersList(BigDecimal money) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        int gameCount = money.divide(MONEY_PER_GAME, RoundingMode.DOWN).intValue();

        for (int i = 0; i < gameCount; i++) {
            lottoNumbers.add(new LottoNumbers(LottoNumberPublisher.getShuffleSixLottoNumber()));
        }

        return lottoNumbers;
    }

    private static WinningInfos generateLottoWinningInfos(List<LottoNumbers> lottoNumbersList, LottoWinningNumbers lottoWinningNumbers) {
        WinningInfos winningInfos = WinningInfos.of();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            LottoWinningType winningType = lottoWinningNumbers.getWinningType(lottoNumbers);
            winningInfos.add(winningType);
        }
        return winningInfos;
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }

    public WinningInfos getWinningInfos() {
        return winningInfos;
    }

    public double getBenefitRate() {
        return benefitRate;
    }
}
