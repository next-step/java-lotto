package lotto.application;

import java.util.List;
import lotto.domain.generator.AutoLottosGenerator;
import lotto.domain.Lotto;
import lotto.domain.generator.CompositeLottosGenerator;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.Lottos;
import lotto.domain.generator.LottosGenerator;
import lotto.domain.generator.ManualLottosGenerator;
import lotto.domain.generator.MixedLottosGenerator;
import lotto.domain.Money;

public class LottoMachine {
    private final LottoNumberGenerator numberGenerator;

    public LottoMachine(LottoNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos issue(Money money) {
        LottosGenerator auto = new AutoLottosGenerator(money.ticketCount(), numberGenerator);
        return auto.generate();    }


    public Lottos issue(Money money, List<Lotto> manualLottos) {
        int totalCount = money.ticketCount();
        int manualCount = manualLottos.size();

        if (manualCount > totalCount) {
            throw new IllegalArgumentException("수동 로또 개수는 전체 구매 개수보다 클 수 없습니다.");
        }

        int autoCount = totalCount - manualCount;

        LottosGenerator manual = new ManualLottosGenerator(manualLottos);
        LottosGenerator auto = new AutoLottosGenerator(autoCount, numberGenerator);

        return CompositeLottosGenerator.of(manual, auto).generate();
    }
}
