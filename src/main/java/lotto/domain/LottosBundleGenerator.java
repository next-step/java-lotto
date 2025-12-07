package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottosBundleGenerator implements LottoGenerator{
    private final LottoPurChase lottoPurChase;
    private final List<String> manualLottoText;

    public LottosBundleGenerator(LottoPurChase lottoPurChase, List<String> manualLottoText) {
        this.lottoPurChase = lottoPurChase;
        this.manualLottoText = manualLottoText;
    }

    @Override
    public List<Lotto> generate() {
        // ManualLottosGenerator 활용해 수동 로또 생성
        List<Lotto> manualLottos = new ManualLottosGenerator(manualLottoText).generate();

        // AutoLottosGenerator 활용해 자동 로또 생성(수동 로또 수 만큼 Money 차감)
        List<Lotto> autoLottos = new AutoLottoGenerator(lottoPurChase.deductManualLottoCost()).generate();

        return Stream.concat(manualLottos.stream(), autoLottos.stream()).collect(Collectors.toList());
    }
}
