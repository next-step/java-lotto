package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static final String WINNING_NUMBER_EMPTY_MSG = "당첨번호는 빈 값 일 수 없습니다.";
    private static final String INVALID_AMOUNT = "로또 금액보다 높은 금액을 입력해야 합니다.";
    private static final int LOTTO_AMOUNT = 1000;
    public static final String SPLIT_TEXT = ",";
    private Lottos lottos;

    public LottoGame(final Lottos lottos) {
        this.lottos = lottos;
    }

    public LottoGame(final Amount purchaseAmount) {
        validationCheckAmount(purchaseAmount);
        this.lottos = new Lottos(purchaseAmount);
    }

    private void validationCheckAmount(final Amount purchaseAmount) {
        if (purchaseAmount.isSmallThan(new Amount(LOTTO_AMOUNT))) {
            throw new IllegalArgumentException(INVALID_AMOUNT);
        }
    }

    public int purchaseCount() {
        return lottos.purchaseCount();
    }

    public Winning draw(final String winningNumberText, final int bonusNumber) {
        validationCheck(winningNumberText);

        List<Integer> winningNumbers = parsingText(winningNumberText);

        return lottos.draw(winningNumbers, bonusNumber);
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
