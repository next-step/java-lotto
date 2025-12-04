package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MixedLottoGenerator implements LottoGenerator {
    private final LottoPurChase lottoPurchase;
    private final List<Lotto> manualLottos;

    public MixedLottoGenerator(LottoPurChase lottoPurchase, List<Lotto> manualLottos) {
        this.lottoPurchase = lottoPurchase;
        this.manualLottos = manualLottos;
    }

    @Override
    public List<Lotto> generate() {
        List<Lotto> lottoArray = new ArrayList<>(manualLottos);

        for (int i = 0; i < lottoPurchase.getAutoCount(); i++) {
            lottoArray.add(new Lotto(LottoMachine.createLottoNumbers()));
        }

        return lottoArray;
    }
}
