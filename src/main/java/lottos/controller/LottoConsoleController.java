package lottos.controller;

import lottos.domain.Lotto;
import lottos.domain.LottoGenerator;
import lottos.domain.Lottos;
import lottos.domain.WinningLotto;
import lottos.domain.exceptions.LottoSizeIncorrectException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class LottoConsoleController {

    private static final String NUMBERS_TEXT_SPLIT_REGEX = ",";

    private final LottoGenerator generator;

    public LottoConsoleController(LottoGenerator generator) {
        this.generator = generator;
    }

    public Lottos buy(final int purchaseAmount, final int manualLottoCount) {
        return new Lottos(purchaseAmount, manualLottoCount, generator);
    }

    public Lottos buy(final List<String> numberTexts) {
        List<Lotto> lottos = new ArrayList<>();
        for (String numberText : numberTexts) {
            lottos.add(new Lotto(parseTextToNumbers(numberText)));
        }
        return new Lottos(lottos, generator);
    }

    public WinningLotto lastWeeksWinningLotto(final String lastWeeksNumbersText, final String bonusNumberText) {
        return new WinningLotto(parseTextToNumbers(lastWeeksNumbersText), parseTextToBonusNumbers(bonusNumberText));
    }

    private List<Integer> parseTextToNumbers(final String numbersText) {
        if (numbersText == null || numbersText.isEmpty()) {
            throw new LottoSizeIncorrectException();
        }
        return Arrays.stream(numbersText.split(NUMBERS_TEXT_SPLIT_REGEX))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private Integer parseTextToBonusNumbers(final String bonusNumberText) {
        return Integer.parseInt(bonusNumberText);
    }
}
