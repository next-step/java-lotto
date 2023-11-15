package me.namuhuchutong.lotto.ui;

import me.namuhuchutong.lotto.dto.LottoResult;

public class OutputView {

    private static final long MINIMUM_COUNT = 3;
    private static final String RESULT_BANNER = "------------ Lotto Result -----------\n";
    private static final String TOTAL_RESULT = "\n총 수익률: ";
    private static final String NEW_LINE = "\n";

    public void showLottoResult(int amount, LottoResult lottoResult) {
        System.out.printf(buildResultBanner(amount, lottoResult));
    }

    private String buildResultBanner(int amount, LottoResult lottoResult) {
        return RESULT_BANNER +
                lottoResult.getLottoCountResult(MINIMUM_COUNT) +
                TOTAL_RESULT +
                addWinnings(amount, lottoResult);
    }

    private String addWinnings(int amount, LottoResult lottoResult) {
        return String.format("%.2f", getRevenue(amount, lottoResult)) + NEW_LINE;
    }

    private double getRevenue(int amount, LottoResult lottoResult) {
        return  lottoResult.getWinnings(MINIMUM_COUNT) / ((double) amount);
    }

    public void showGeneratedLotto(LottoResult lottoResult) {
        System.out.println(lottoResult.getLottoCountResult(0));
    }
}
