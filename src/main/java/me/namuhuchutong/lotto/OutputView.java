package me.namuhuchutong.lotto;

public class OutputView {

    private static final String NEW_LINE = "\n";

    public void showLottoResult(int amount, LottoResult lottoResult) {
        System.out.printf(buildResultBanner(amount, lottoResult));
    }

    private String buildResultBanner(int amount, LottoResult lottoResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------------ Lotto Result -----------");
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(lottoResult.getLottoCountResult());
        stringBuilder.append("\n");
        stringBuilder.append("총 수익률: ");
        stringBuilder.append(addWinnings(amount, lottoResult));
        return stringBuilder.toString();
    }

    private String addWinnings(int amount, LottoResult lottoResult) {
        return (lottoResult.getWinnings() / amount) + "\n";
    }
}
