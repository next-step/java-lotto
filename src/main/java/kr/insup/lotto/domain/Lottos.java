package kr.insup.lotto.domain;

import kr.insup.lotto.utils.LottoAutoGenerator;
import kr.insup.lotto.utils.LottoManualGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();
    private Integer attempt;

    public Lottos(Integer attempt) {
        this.attempt = attempt;

        for (int i = 0; i < attempt; i++) {
            lottos.add(new Lotto(new LottoAutoGenerator()));
        }
    }

    public Lottos(int autoAttempt, List<String> manualStringLottoNumbers) {
        this(autoAttempt);

        for (String stringNumber : manualStringLottoNumbers) {
            lottos.add(new Lotto(new LottoManualGenerator(stringNumber)));
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
