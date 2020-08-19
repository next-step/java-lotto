package cc.oakk.lotto;

import cc.oakk.lotto.model.Lotto;
import cc.oakk.lotto.model.LottoGenerator;
import cc.oakk.lotto.model.LottoPrizeProvider;
import cc.oakk.lotto.model.SimpleLottoPrizeProvider;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator();
        LottoPrizeProvider<Long> provider = new SimpleLottoPrizeProvider();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lottos.add(generator.generate());
        }
        Lotto winningLotto = generator.generate();
        System.out.println(winningLotto);
        System.out.println();
        lottos.forEach(l -> {
            System.out.println(l);
            System.out.println(provider.getPrizeByRank(l.compare(winningLotto)));
        });
    }
}
