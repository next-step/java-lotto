package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBox {

    private final List<Lotto> lottos;

    public LottoBox(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public List<CorrectInfo> retrieveCorrectNum(Lotto winningLotto, LottoBall bonusBall) {
        List<CorrectInfo> CorrectInfos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int correctCount = lotto.retrieveCorrectLottoBallCount(winningLotto);
            boolean bonusMatch = lotto.matchBounsBall(bonusBall);
            CorrectInfos.add(new CorrectInfo(correctCount, bonusMatch));
        }

        return CorrectInfos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
