package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.MatchResult;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final String WINNING_DELIMITER = ", ";

    public static MatchResult playLotto(Lottos lottos, String winningInput) {
        return lottos.getResult(getWinningNumbers(winningInput));
    }

    private static WinningNumbers getWinningNumbers(String winningInput) {
        String[] inputs = winningInput.split(WINNING_DELIMITER);
        List<Integer> winningNumbers = new ArrayList<>();

        for (String input : inputs) {
            winningNumbers.add(Integer.parseInt(input));
        }

        return WinningNumbers.getInstance(winningNumbers, InputView.getBonusNumber());
    }
}
