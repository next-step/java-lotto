package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private Lotto lotto;

    public LottoMachine(Lotto lotto) {
        this.lotto = lotto;
    }

    public GameResult playLotto(String winningNumbers, int bonus) {
        return new GameResult(lotto.getTickets(), convertWinningNumbers(winningNumbers, bonus));
    }

    protected static WinningLotto convertWinningNumbers(String s, int bonus) {
        String [] numbers = s.replace(" ", "").split(",");

        List<Integer> winningNumbers = Arrays.stream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return new WinningLotto(winningNumbers, bonus);
    }
}
