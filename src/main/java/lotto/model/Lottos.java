package lotto.model;

import lotto.autoLottoGenerator.AutoLottoGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> allLottos;

    private Lottos(List<Lotto> allLottos) {
        this.allLottos = Collections.unmodifiableList(allLottos);
    }

    public static Lottos getAllLottos(int autoLottoCount, List<Lotto> manulLottos) {
        List<Lotto> lottos = generateAutoLottos(autoLottoCount);
        for (Lotto manualLotto : manulLottos) {
            lottos.add(manualLotto);
        }
        return new Lottos(lottos);
    }

    public List<Rank> match(WinningLotto winningLotto) {
        return allLottos.stream()
                .map(it -> it.match(winningLotto))
                .collect(Collectors.toList());
    }

    private static List<Lotto> generateAutoLottos(int autoLottoCount) {
        return AutoLottoGenerator.generate(autoLottoCount);
    }

    public int getToTalLottoCount() {
        return allLottos.size();
    }

    public List<Lotto> getAllLottos() {
        return allLottos;
    }
}
