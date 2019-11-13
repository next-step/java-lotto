package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottosGenerator implements LottosGenerator {
    private static final String DELIMITER = ", ";
    List<String> manualLottos;

    public ManualLottosGenerator(List<String> manualLottos) {
        this.manualLottos = manualLottos;
    }

    @Override
    public List<Lotto> generate() {
        List<Lotto> gereratorLottos = new ArrayList<>();
        for (String manualLotto : this.manualLottos) {
            gereratorLottos.add(generateLotto(manualLotto.split(DELIMITER)));
        }
        return gereratorLottos;
    }

    public Lotto generateLotto(String[] manualLotto) {
        List<Integer> lotto = Arrays.stream(manualLotto)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(lotto);
    }
}
