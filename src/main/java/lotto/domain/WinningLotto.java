package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private Lotto winningLotto;

    public WinningLotto(String winningNumber) {
        this.winningLotto = generateWinningLotto(splitNumber(winningNumber));
    }

    private Lotto generateWinningLotto(List<Integer> winningNumbers){
        Lotto lotto = winningLotto.generateLotto(winningNumbers);
        return lotto;
    }

    private List<Integer> splitNumber(String winningNumber) {
        String[] strings = winningNumber.split(",");

        int[] ints =  Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .toArray();

        return Arrays.stream(ints)
                .boxed()
                .collect(Collectors.toList());
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

}
