package lotto.service;

import lotto.domain.*;
import lotto.request.ManualRequest;
import lotto.response.LottoStatusResponse;
import lotto.util.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private static final Money LOTTO_PRICE = new Money(1000);

    private final Lottos lottos;
    private final Count manualCount;

    private LottoService(Lottos lottos, Count manualCount) {
        this.lottos = lottos;
        this.manualCount = manualCount;
    }

    public static LottoService buyLotto(Money money, LottoGenerator lottoGenerator) {
        return buyLotto(money, new ManualRequest(new ArrayList<>()), lottoGenerator);
    }

    public static LottoService buyLotto(Money money, ManualRequest manualRequest, LottoGenerator lottoGenerator) {
        Count manualCount = new Count(manualRequest.size());
        Count autoCount = money.count(LOTTO_PRICE).decreaseBy(manualCount);
        Lottos manualLottos = lottoGenerator.generateManualLotto(manualRequest);
        List<Lotto> lottos = autoCount.stream()
                .mapToObj(l -> lottoGenerator.generateAutoLotto())
                .collect(Collectors.toList());
        return new LottoService(manualLottos.combine(new Lottos(lottos)), manualCount);
    }

    public static void validateManualCount(Money money, int manualCount) {
        money.count(LOTTO_PRICE).decreaseBy(new Count(manualCount));
    }

    public LottoStatusResponse buyStatus() {
        return new LottoStatusResponse(lottos, manualCount);
    }

    public LottoResults matchWinningLotto(WinningLotto winningNumbers) {
        return lottos.matchWinningLotto(winningNumbers);
    }
}
