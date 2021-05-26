package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.domain.generator.AutoLottosGenerator;
import lotto.domain.generator.LottosGenerator;

public class LottoMachine {
    private final List<Lotto> lottos;

    private LottoMachine(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoMachine of(LottosGenerator generator, Money money) {
        return new LottoMachine(generator.generate(money));
    }

    public static LottoMachine of(List<Lotto> lottos) {
        return new LottoMachine(lottos);
    }

    public static List<Lotto> generateAutoLottos(LottoTicketCount autoLottoTicketCount) {
        LottosGenerator generator = new AutoLottosGenerator();
        return generator.generate(autoLottoTicketCount);
    }

    public static List<Lotto> generateManualLottos(List<String> stringNumbers) {
        List<Lotto> lottoList = new ArrayList<>();
        return lottoList;
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public LottoWin result(Lotto winLotto) {
        LottoWin lottoWin = new LottoWin();

        lottos.forEach(lotto -> {
            int matchCount = lotto.match(winLotto);
            lottoWin.hit(matchCount);
        });
        return lottoWin;
    }

    public LottoWin result(Lotto winLotto, LottoNumber bonusBall) {
        LottoWin lottoWin = new LottoWin();
        lottos.forEach(lotto -> {
            int matchCount = lotto.match(winLotto);
            boolean bonus = lotto.matchBonus(bonusBall);
            lottoWin.hit(matchCount, bonus);
        });
        return lottoWin;
    }
}
