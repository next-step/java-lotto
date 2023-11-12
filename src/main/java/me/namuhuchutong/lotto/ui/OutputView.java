package me.namuhuchutong.lotto.ui;

import me.namuhuchutong.lotto.dto.LottoResult;

public class OutputView {

    private static final String NEW_LINE = "\n";

    private static final long MINIMUM_COUNT = 3;
    private static final String RESULT_BANNER = "------------ Lotto Result -----------";
    private static final String TOTAL_RESULT = "총 수익률: ";

    public void showLottoResult(int amount, LottoResult lottoResult) {
        System.out.printf(buildResultBanner(amount, lottoResult));
    }

    private String buildResultBanner(int amount, LottoResult lottoResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RESULT_BANNER);
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(lottoResult.getLottoCountResult(MINIMUM_COUNT));
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(TOTAL_RESULT);
        stringBuilder.append(addWinnings(amount, lottoResult));
        return stringBuilder.toString();
    }

    private String addWinnings(int amount, LottoResult lottoResult) {
        return (double) (lottoResult.getWinnings(MINIMUM_COUNT) / amount) + NEW_LINE;
    }

    public void showGeneratedLotto(LottoResult lottoResult) {
        System.out.println(lottoResult.getLottoCountResult(0));
    }
}
