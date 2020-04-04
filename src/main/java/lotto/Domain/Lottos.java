package lotto.Domain;


import java.util.*;

public class Lottos {

    private List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos init(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    public void add(Lotto lotto) {
        lottoList.add(lotto);
    }

    public LottoResult match(WinningLotto winningNumber) {
        LottoResult statistics = LottoResult.init();
        for (Lotto lotto : lottoList) {
            LottoGrade matchGrade = lotto.match(winningNumber);
            statistics.addWinGrade(matchGrade);
        }
        return statistics;
    }

    public List<Lotto> toList() {
        return Collections.unmodifiableList(lottoList);
    }
}
