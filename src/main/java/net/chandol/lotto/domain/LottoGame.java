package net.chandol.lotto.domain;

import net.chandol.lotto.domain.generator.AutoLottoGenerator;
import net.chandol.lotto.domain.generator.DirectLottoGenerator;
import net.chandol.lotto.dto.PurchaseRequest;
import net.chandol.lotto.view.ViewUtil;
import net.chandol.lotto.value.LottoNumber;
import net.chandol.lotto.value.WinningNumber;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Stream.generate;

public class LottoGame {
    private PurchaseRequest request;
    private List<Lotto> lottos;

    public LottoGame(PurchaseRequest request) {
        List<Lotto> directLottos = new DirectLottoGenerator().generate(request);
        List<Lotto> autoLottos = new AutoLottoGenerator().generate(request);
        List<Lotto> lottos = ViewUtil.merge(directLottos, autoLottos);

        this.lottos = lottos;
        this.request = request;
    }

    public List<Lotto> getLottos() {
        return unmodifiableList(lottos);
    }

    public LottoGameResult getLottoGameResult(WinningNumber winningNumber) {
        LottoPrizeCalculator calculator = new LottoPrizeCalculator(winningNumber);
        return calculator.lottoGameResult(lottos);
    }

    public static List<LottoNumber> getAutoLottoNumbers(int size) {
        return generate(LottoNumber::auto)
                .limit(size).collect(Collectors.toList());
    }
}
