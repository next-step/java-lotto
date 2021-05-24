package kr.insup.lotto.domain;

import kr.insup.lotto.utils.LottoAutoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();
    private final int attempt;

    public Lottos(int attempt) {
        this.attempt = attempt;

        for (int i = 0; i < attempt; i++) {
            lottos.add(new Lotto(new LottoAutoGenerator()));
        }
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> lottoList() {
        return lottos;
    }

    public Statistics statistics(WinningLotto winningNumber) {
        Statistics statistics = new Statistics(attempt);

        for (Lotto lotto : lottos) {
            LottoPrize lottoPrize = lotto.matchWinningNumber(winningNumber);
            statistics.addCountToPlace(lottoPrize);
        }

        return statistics;
    }
}
