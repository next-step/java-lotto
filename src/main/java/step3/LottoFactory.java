package step3;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoFactory {
    private static final int LOTTO_PICK_START = 0;
    private static final int LOTTO_PICK_END = 5;
    private final LottoNumber lottoNumber = new LottoNumber();

    public Set<Integer> getRandomLotto() {
        List<Integer> shuffleLottoNumber = lottoNumber.shuffle();
        Set<Integer> shuffle = new TreeSet<>();

        for (int i = LOTTO_PICK_START; i <= LOTTO_PICK_END; i++) {
            shuffle.add(shuffleLottoNumber.get(i));
        }
        return shuffle;
    }

    public WinningLotto makeWinningLotto(Set<Integer> winningNumber, int bonus) {
        return new WinningLotto(winningNumber, bonus);
    }
}
