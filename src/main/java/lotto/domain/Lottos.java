package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private static final int MIN_COUNT = 0;

    private final List<Lotto> lottos;

    public Lottos(int autoCount, List<String> manualNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(pickManualLotto(manualNumbers));
        lottos.addAll(pickAutoLotto(autoCount));

        this.lottos = lottos;
    }

    private List<Lotto> pickAutoLotto(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("구매 개수는 0 미만일 수 없습니다.");
        }

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.pickAutoNumber());
        }
        return lottos;
    }

    private List<Lotto> pickManualLotto(List<String> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("수동 구매 넘버는 null일 수 없습니다.");
        }

        List<Lotto> lottos = new ArrayList<>();
        for (String lottoNumber : lottoNumbers) {
            lottos.add(Lotto.pickManualNumber(lottoNumber));
        }
        return lottos;
    }

    public Ranks checkWinning(WinLotto winLotto) {
        return winLotto.checkWinning(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int size() {
        return lottos.size();
    }

}
