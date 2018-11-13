package game.lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutoLottosGenerator implements LottosGenerator {

    private final Amount amount;

    public AutoLottosGenerator(Amount amount) {
        this.amount = amount;
    }

    @Override
    public List<Lotto> generate() {
        Set<Lotto> lottos = new HashSet<>();
        while (!amount.isSameAutoCount(lottos.size())) {
            Lotto randomLotto = Lotto.auto();
            lottos.add(randomLotto);
        }
        return new ArrayList<>(lottos);
    }
}
