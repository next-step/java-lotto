package step2.domain;

import java.util.Map;

public class LottoGameResult {

    public LottoGameResultDto getResult(LottoSheet lottoSheet,
        WinningLotto winningLotto,
        UserPrice userPrice) {

        Map<Prize, Integer> prizeResult = lottoSheet.getPrizeResult(winningLotto);

        return new LottoGameResultDto(
            getEarningRate(lottoSheet, winningLotto, userPrice), prizeResult);
    }

    private long getTotalCashPrize(LottoSheet lottoSheet, WinningLotto winningLotto) {
        long totalCashPrize = lottoSheet.getLottos().stream()
            .mapToLong(lotto -> lotto.getPrize(winningLotto).getCashPrize()).sum();
        return totalCashPrize;
    }

    private double getEarningRate(LottoSheet lottoSheet, WinningLotto winningLotto, UserPrice userPrice) {
        return (double) getTotalCashPrize(lottoSheet, winningLotto) / userPrice.getPrice();
    }
}
