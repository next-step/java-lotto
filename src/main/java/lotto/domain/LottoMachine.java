package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private Lotto lotto;

    public LottoMachine(Lotto lotto) {
        this.lotto = lotto;
    }

    public GameResult playLotto(String winningNumbers) {
        return new GameResult(lotto.getTickets(), convertWinningNumbers(winningNumbers));
    }

    public static Ticket convertWinningNumbers(String s) {
        String [] numbers = s.replace(" ", "").split(",");

        List<Integer> winningNumbers = Arrays.stream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return new Ticket(winningNumbers);
    }
}
