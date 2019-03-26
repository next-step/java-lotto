package lotto.dto;

import java.util.List;

public class WinningLotto {
    private static List<Integer> winningLotto;

    public static void createWinningLotto(List<Integer> numbers) {
        winningLotto = numbers;
    }

    public static List<Integer> getWinningLotto() {
        return winningLotto;
    }
}
