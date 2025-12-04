package lottogame.model.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ManualLottos {
    private final List<Set<Integer>> manualLottos;

    public ManualLottos(List<Set<Integer>> ManualLottos) {
        this.manualLottos = ManualLottos;
    }

    public int size() {
        return manualLottos.size();
    }

    public Set<Integer> findManualLottoByIdx(int idx) {
        if (idx < 0 || idx >= this.manualLottos.size()) {
            return Set.of();
        }

        return manualLottos.get(idx);
    }

    public Lottos convertToLottos() {
        List<Lotto> tempLottos = new ArrayList<>(size());
        for (int i = 0; i < size(); i++) {
            Set<LottoNum> lottoNums = LottoMachine.createLottoNums(findManualLottoByIdx(i));
            tempLottos.add(new Lotto(lottoNums));
        }

        return new Lottos(tempLottos);
    }
}
