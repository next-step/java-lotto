package lotto.service;

import lotto.domain.*;
import lotto.dto.LottoStatusResponseDto;
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
        return buyLotto(money, new Lottos(new ArrayList<>()), lottoGenerator);
    }

    public static LottoService buyLotto(Money money, Lottos manualLottos, LottoGenerator lottoGenerator) {
        Count autoCount = money.count(LOTTO_PRICE);
        List<Lotto> lottos = autoCount.stream()
                .mapToObj(l -> lottoGenerator.generateLotto())
                .collect(Collectors.toList());
        return new LottoService(manualLottos.combine(new Lottos(lottos)), new Count(manualLottos.size()));
    }

    public LottoStatusResponseDto buyStatus() {
        return new LottoStatusResponseDto(lottos, manualCount);
    }

    public LottoResults matchWinningLotto(WinningLotto winningNumbers) {
        return lottos.matchWinningLotto(winningNumbers);
    }
}
