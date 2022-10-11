package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBox {

    List<Lotto> lottos;

    public LottoBox(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public List<Integer> retrieveCorrectNum(Lotto winningLotto) {
        List<Integer> correctCounts = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int correctCount = lotto.retrieveCorrectLottoBallCount(winningLotto);
            correctCounts.add(correctCount);
        }
        return correctCounts;
    }

    public List<Lotto> getLottos() {
        return lottos.stream()
                .map(lotto -> new Lotto(lotto.retrieveNumbers()))
                .collect(Collectors.toList());
    }
}
