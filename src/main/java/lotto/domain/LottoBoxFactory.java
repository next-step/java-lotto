package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.strategy.ExtractStrategy;

public class LottoBoxFactory {

    private LottoBoxFactory() {
    }

    public static LottoBox createLottoBox(int autoCount, ExtractStrategy extractStrategy, List<Lotto> manualLotto) {
        List<Lotto> lottos = copyLottos(manualLotto);
        lottos.addAll(createAutoLottos(autoCount, extractStrategy));
        return new LottoBox(lottos);
    }

    private static List<Lotto> copyLottos(List<Lotto> manualLotto) {
        return manualLotto.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private static List<Lotto> createAutoLottos(int autoCount, ExtractStrategy extractStrategy) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            Lotto lotto = extractStrategy.extractNumber();
            lottos.add(lotto);
        }
        return lottos;
    }
}
