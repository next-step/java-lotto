package step3.iksoo.lotto2rd;

import java.util.*;
import java.util.stream.IntStream;

public class Lottoes {
    private List<Lotto> lottoes;

    Lottoes(int orderCount) {
        this.lottoes = buyLotto(orderCount);
    }

    private List<Lotto> buyLotto(int orderCount) {
        List<Lotto> lottoBox = new ArrayList<>();
        IntStream.range(0, orderCount)
                .boxed()
                .forEach(n -> lottoBox.add(new Lotto()));
        return lottoBox;
    }

    public void add(Lotto lotto) {
        this.lottoes.add(lotto);
    }

    public Map<Rank, Integer> checkLotteryWin(List<Integer> winnerNumbers, int bonusBall) {
        Map<Rank, Integer> matchResult = new HashMap<>();

        Arrays.stream(Rank.values())
                .forEach(rank -> matchResult.put(rank, 0));

        this.lottoes
                .stream()
                .map(lotto -> lotto.checkNumberOfMatches(winnerNumbers, bonusBall))
                .filter(rank -> rank.getCountOfMatch() >= Rank.FIFTH.getCountOfMatch())
                .forEach(rank -> matchResult.put(rank, matchResult.get(rank) + 1));

        return matchResult;
    }

    public List<Lotto> getLottoes() {
        return this.lottoes;
    }
}