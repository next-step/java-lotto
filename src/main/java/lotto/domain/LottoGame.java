package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static final String WINNING_NUMBER_EMPTY_MSG = "당첨번호는 빈 값 일 수 없습니다.";
    public static final String SPLIT_TEXT = ",";
    private Lottos lottos;
    public LottoGame(final int purchaseAmount) {
        this.lottos = new Lottos(new Amount(purchaseAmount));
    }

    public int purchaseCount() {
        return lottos.purchaseCount();
    }

    public WinnerCount draw(final String winningNumberText) {
        validationCheck(winningNumberText);

        List<Integer> winningNumbers = parsingText(winningNumberText);

        return lottos.draw(winningNumbers);
    }

    private List<Integer> parsingText(final String winningNumberText) {
        final String[] winningNumberTokens = winningNumberText.split(SPLIT_TEXT);

        List<Integer> winningNumbers = new ArrayList<>();
        for (String token : winningNumberTokens) {
            winningNumbers.add(Integer.valueOf(token.trim()));
        }

        return winningNumbers;
    }

    private void validationCheck(final String winningNumberText) {
        if (isNullOrEmpty(winningNumberText)) {
            throw new IllegalArgumentException(WINNING_NUMBER_EMPTY_MSG);
        }
    }

    private boolean isNullOrEmpty(final String winningNumberText) {
        return winningNumberText == null || winningNumberText.isBlank();
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
