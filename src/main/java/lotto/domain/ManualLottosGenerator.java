package lotto.domain;

import lotto.Rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottosGenerator implements LottosGenerator {

    private static final String DELIMITER = ", ";

    public ManualLottosGenerator(List<String> manualLottos) {
        this.lottos = generateLottos(manualLottos);
    }

    @Override
    public Lottos generate(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    private List<Lotto> generateLottos(List<String> manualLottos) {
        List<Lotto> gereratorLottos = new ArrayList<>();
        for (String manualLotto : manualLottos) {
            gereratorLottos.add(generateLotto(manualLotto.split(DELIMITER)));
        }
        return gereratorLottos;
    }

    private Lotto generateLotto(String[] manualLotto) {
        List<LottoNo> lotto = Arrays.stream(manualLotto)
                .map(number -> new LottoNo(Integer.parseInt(number)))
                .collect(Collectors.toList());
        return new Lotto(lotto);
    }


}
