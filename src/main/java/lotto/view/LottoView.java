package lotto.view;

import lotto.InputTool;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoView {

    private static final String PURCHASE_QUESTION_TEXT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT_TEXT = "%s개를 구매했습니다.";
    private static final String WIN_QUESTION_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WIN_RESULT_TEXT = "당첨통계\n----------";
    private static final String MATCH_RESULT_TEXT = "%d개 일치 (%d원)- %d개";
    private static final String PROFIT_RATE_RESULT_TEXT = "총 수익률은 %.2f 입니다.";
    private static final String LOTTO_NUMBER_PREFIX = "[";
    private static final String LOTTO_NUMBER_POSTFIX = "]";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private final InputTool inputTool = new InputTool();

    public int getMoney() {
        drawText(PURCHASE_QUESTION_TEXT);
        return inputTool.readLineToInt();
    }

    public List<Integer> getWinningLottoNumbers() {
        newLine();
        drawText(WIN_QUESTION_TEXT);

        String[] lottoNumberTexts = inputTool.readLine().replace(" ", "").split(",");
        return textsToNumbers(lottoNumberTexts);
    }

    private List<Integer> textsToNumbers(String[] texts) {
        return Arrays.stream(texts)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public void showLottoNumbers(LottoNumbers lottoNumbers) {
        drawText(String.format(PURCHASE_RESULT_TEXT, lottoNumbers.size()));

        for (LottoNumber each : lottoNumbers.getLottoNumbers()) {
            drawText(getNumbersText(each.getNumbers()));
        }
    }

    private String getNumbersText(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER, LOTTO_NUMBER_PREFIX, LOTTO_NUMBER_POSTFIX));
    }

    public void showRankResult(Map<LottoRank, Long> rankGroup) {
        newLine();
        drawText(WIN_RESULT_TEXT);
        showStatistics(rankGroup);
    }

    private void showStatistics(Map<LottoRank, Long> rankGroup) {
        Arrays.stream(LottoRank.values())
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> {
                    Long rankCount = rankGroup.get(rank);
                    drawText(String.format(MATCH_RESULT_TEXT, rank.getMatchCount(), rank.getWinning(), rankCount == null ? 0 : rankCount));
                });
    }

    public void showProfitRate(double profitRate) {
        drawText(String.format(PROFIT_RATE_RESULT_TEXT, profitRate));
    }

    private void drawText(String text) {
        System.out.println(text);
    }

    private void newLine() {
        drawText(System.lineSeparator());
    }
}
