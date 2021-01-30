package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private static List<Integer> winningLottos;
    private int bonusBall;

    private WinningLotto(Lotto winningLotto, int bonusBall) {
        this.winningLottos = winningLotto.getLottoNumbers();
        this.bonusBall = bonusBall;
    }

    public static WinningLotto generate(Lotto winningLotto, int bonusBall) {
        return new WinningLotto(winningLotto, bonusBall);
    }

    public int getWinningCount(Lotto lotto) {
        return (int) winningLottos.stream()
                .filter(lotto.getLottoNumbers()::contains)
                .count();
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottos;
    }

    public int getBonusBall() {
        return bonusBall;
    }


//    public LottoResult result(WinningLotto winningLotto) {
//        return LottoResult.generate(getWinningRank(winningLotto));
//    }
//
//    public List<Rank> getWinningRank(WinningLotto winningLotto) {
//        return this.lottos.stream()
//                .filter(winningLotto::isWinningTarget)
//                .map(lotto -> Rank.match(winningLotto.getWinningCount(lotto), lotto.hasBonusBall(winningLotto.getBonusBall())))
//                .collect(Collectors.toList());
//    }
}
