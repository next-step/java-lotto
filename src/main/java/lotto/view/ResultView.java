package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;

public class ResultView {

    private final String RESULT_MESSAGE = "당첨 통계.\n------";
    private StringBuilder uiBuilder = new StringBuilder();
    private int[] matchingStandard = { 3, 4, 5, 6 };

    public void displayLottoNumbers(List<String[]> lottoNumbers){
        uiBuilder.setLength(0);
        for (String[] lottoNumber : lottoNumbers) {
            uiBuilder.append("[" + String.join(",", lottoNumber) + "]\n");
        }
        System.out.println(uiBuilder.toString());
    }

    public void displayResult(List<LottoResult> lottoResults, int paymentPrice) {
        System.out.println(RESULT_MESSAGE);
        for (int standard : matchingStandard) {
            int count = (int) lottoResults
                    .stream()
                    .filter(o -> o.getMatchingCount() == standard)
                    .count();
            System.out.println(standard + "개 일치(" + Lotto.getLottoPrize(standard) + ") - " + count + "개");
        }
        int totalPrize = lottoResults.stream().mapToInt(LottoResult::getPrize).sum();
        System.out.println("총 수익률은 " + getProfit(totalPrize, paymentPrice) + "입니다.");
    }

    private String getProfit(int totalPrize, int paymentPrice) {
        return String.format("%.02f", (float) totalPrize / paymentPrice);
    }

}