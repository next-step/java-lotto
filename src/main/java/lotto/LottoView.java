package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoView {

    private static final String PRICE_QUESTION_TEXT = "구입금액을 입력해 주세요.";

    private final InputTool inputTool = new InputTool();

    int getPrice() {
        drawText(PRICE_QUESTION_TEXT);
        return inputTool.readLineToInt();
    }

    void showLottoNumbers(LottoNumbers lottoNumbers) {
        for (LottoNumber each : lottoNumbers.getLottoNumbers()) {
            drawText(getNumbersText(each.getNumbers()));
        }
    }

    private String getNumbersText(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("[", ",", "]"));
    }

    void showLottoRanks(List<LottoRank> lottoRanks) {

    }

    private void drawText(String text) {
        System.out.println(text);
    }
}
