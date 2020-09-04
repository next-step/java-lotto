package domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static utility.UserInput.SC;

public class LottoGames {

    private Lottos lottos;

    public LottoGames(int autoTries , int manualTries) {
        lottos = new Lottos();

        makeLottoManual(manualTries);
        makeLottoAuto(autoTries);
    }

    private void makeLottoManual(int manualTries) {
        Set<LottoNo> manualLotto;
        String[] inputs;

        for (int i = 0; i < manualTries; i++) {
            inputs = SC.nextLine().split(",");
            manualLotto = Arrays.stream(inputs)
                    .mapToInt(Integer::parseInt)
                    .mapToObj(e->new LottoNo(e))
                    .collect(Collectors.toSet());

            lottos.addLotto(new Lotto(manualLotto));
        }
    }

    private void makeLottoAuto(int autoTries) {
        NumberGenerator generator = new NumberGenerator();

        for (int i = 0; i < autoTries; i++) {
            lottos.addLotto(new Lotto(generator.generate()));
        }
    }
    public Lottos getLottos() {
        return lottos;
    }
}
