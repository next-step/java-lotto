package domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static utility.UserInput.SC;
import static utility.UserInput.WON;

public class LottoGames {

    private Lottos lottos;

    public LottoGames(int price, int manualTries) {
        int tries = validatePrice(price);
        int autoTries = tries - manualTries;
        lottos = new Lottos();

        manualMakeLotto(manualTries);
        makeLottoTicket(autoTries);
    }

    private void manualMakeLotto(int manualTries) {
        Set<Integer> manualLotto;
        String[] inputs;

        for (int i = 0; i < manualTries; i++) {
            inputs = SC.nextLine().split(",");
            manualLotto = Arrays.stream(inputs)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toSet());

            lottos.addLotto(new Lotto(manualLotto));
        }
    }

    private void makeLottoTicket(int autoTries) {
        NumberGenerator generator = new NumberGenerator();

        for (int i = 0; i < autoTries; i++) {
            lottos.addLotto(new Lotto(generator.generate()));
        }
    }

    private int validatePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price ERR!");
        }
        return price / WON;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
