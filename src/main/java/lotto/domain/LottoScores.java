package lotto.domain;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoScores {

    private List<LottoScore> lottoScoresList;

    public LottoScores(Lottos lottos, WinningLotto winningLotto) {

        this.lottoScoresList = lottos.getLottos().stream()
                .map(lotto -> new LottoScore(lotto.lottoNumList, winningLotto)).collect(Collectors.toList());

    }

    public List<LottoScore> getLottoScoresList() {
        return Collections.unmodifiableList(lottoScoresList);
    }



}

