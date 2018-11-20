package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.utils.AutomaticallyLottosGenerator;
import lotto.utils.LottosGenerator;

import java.util.List;

import static java.util.Optional.ofNullable;

public class LottoGame {

    private final Lottos lottos;

    public LottoGame(final Money money) throws IllegalArgumentException {
        this(money, new AutomaticallyLottosGenerator(), new Lottos());
    }

    public LottoGame(final Money money, final LottosGenerator lottosGenerator, final Lottos lottos) throws IllegalArgumentException {
        validation(money, lottos);
        this.lottos = lottos;
        lottosGenerator.generate(money).forEach(this.lottos::add);
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    private void validation(final Money money, final Lottos lottos) {
        ofNullable(money).orElseThrow(IllegalArgumentException::new);
        ofNullable(lottos).orElseThrow(IllegalArgumentException::new);
    }

}
