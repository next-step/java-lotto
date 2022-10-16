package lottoGame.model;

import java.util.List;

public class DefaultLotto implements Lotto {
    private final List<Integer> lottoNum;

    public DefaultLotto(List<Integer> lottoNum) {
        this.lottoNum = lottoNum;
    }

    @Override
    public int isContain(List<Integer> winnerNum) {
        return Math.toIntExact(lottoNum.stream()
                .filter(winnerNum::contains)
                .count());
    }
}
