package lotto.application;

import java.util.List;
import lotto.domain.generator.AutoLottosGenerator;
import lotto.domain.Lotto;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.Lottos;
import lotto.domain.generator.LottosGenerator;
import lotto.domain.generator.ManualLottosGenerator;
import lotto.domain.generator.MixedLottosGenerator;
import lotto.domain.Money;

public class LottoMachine {
    private final LottoNumberGenerator generator;

    public LottoMachine(LottoNumberGenerator generator) {
        this.generator = generator;
    }

    public Lottos issue(Money money) {
        return new AutoLottosGenerator(money.ticketCount(), generator).generate();
    }


    public Lottos issue(Money money, List<Lotto> manualLottos) {
        int totalCount = money.ticketCount();
        int manualCount = manualLottos.size();

        if (manualCount > totalCount) {
            throw new IllegalArgumentException("수동 로또 개수는 전체 구매 개수보다 클 수 없습니다.");
        }

        int autoCount = totalCount - manualCount;

        LottosGenerator manual = new ManualLottosGenerator(manualLottos);
        LottosGenerator auto = new AutoLottosGenerator(autoCount, generator);
        LottosGenerator mixed = new MixedLottosGenerator(manual, auto);

        return mixed.generate();
    }
}
