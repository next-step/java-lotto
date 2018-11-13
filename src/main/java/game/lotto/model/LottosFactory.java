package game.lotto.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottosFactory {

    public static Set<Lotto> createRandomLottos(int size) {
        Set<Lotto> lottos = new HashSet<>();
        while (lottos.size() != size) {
            Lotto randomLotto = Lotto.auto();
            lottos.add(randomLotto);
        }
        return lottos;
    }

    public static Set<Lotto> createManualLottos(List<String> manualNumbers) {
        Set<Lotto> manualLottos = manualNumbers.stream()
                .map(LottoNumberFactory::createLottoNumbers)
                .map(Lotto::manual)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        if(manualNumbers.size() != manualLottos.size()) {
            throw new IllegalArgumentException("중복된 수동 번호 목록이 있습니다.");
        }

        return manualLottos;
    }

    public static Set<Lotto> createComplexLottos(Amount amount, List<String> manualNumbers) {
        int totalSize = amount.getTotalAmount();

        Set<Lotto> complex = createManualLottos(manualNumbers);

        while (complex.size() != totalSize) {
            Lotto randomLotto = Lotto.auto();
            complex.add(randomLotto);
        }

        return complex;
    }

}
