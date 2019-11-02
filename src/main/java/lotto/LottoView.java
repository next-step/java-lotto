package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoView {

    private static final String PURCHASE_QUESTION_TEXT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT_TEXT = "%s개를 구매했습니다.";

    private final InputTool inputTool = new InputTool();

    int getMoney() {
        drawText(PURCHASE_QUESTION_TEXT);
        return inputTool.readLineToInt();
    }

    void showLottoNumbers(LottoNumbers lottoNumbers) {
        drawText(String.format(PURCHASE_RESULT_TEXT, lottoNumbers.size()));

        for (LottoNumber each : lottoNumbers.getLottoNumbers()) {
            drawText(getNumbersText(each.getNumbers()));
        }
    }

    private String getNumbersText(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    void showLottoRanks(List<LottoRank> lottoRanks) {

    }

    private void drawText(String text) {
        System.out.println(text);
    }
}
