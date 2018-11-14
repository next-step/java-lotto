package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private Lotto lotto;

    public LottoMachine(Lotto lotto) {
        this.lotto = lotto;
    }

    public GameResult playLotto(String winningNumbers, LottoNo bonus) {
        return new GameResult(lotto.findLottos(), convertWinningNumbers(winningNumbers, bonus));
    }

    protected static WinningLotto convertWinningNumbers(String s, LottoNo bonus) {
        String [] numbers = s.replace(" ", "").split(",");

        List<LottoNo> winningNumbers = Arrays
                .stream(numbers)
                .map(number -> new LottoNo(Integer.valueOf(number)))
                .collect(Collectors.toList());

        return new WinningLotto(winningNumbers, bonus);
    }
}
