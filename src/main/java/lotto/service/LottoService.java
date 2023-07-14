package lotto.service;

import lotto.domain.*;
import lotto.dto.LottoStatusResponseDto;
import lotto.util.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoService {

    private final Lottos lottos;
    private final int manualCount;

    private LottoService(Lottos lottos, int manualCount) {
        this.lottos = lottos;
        this.manualCount = manualCount;
    }

    public static LottoService buyLotto(Money money, LottoGenerator lottoGenerator) {
        return buyLotto(money, new Lottos(new ArrayList<>()), lottoGenerator);
    }

    public static LottoService buyLotto(Money money, Lottos manualLottos, LottoGenerator lottoGenerator) {
        long countLotto = money.countLotto() - manualLottos.size();
        List<Lotto> lottos = LongStream.range(0, countLotto)
                .mapToObj(l -> lottoGenerator.generateLotto())
                .collect(Collectors.toList());
        return new LottoService(manualLottos.combine(new Lottos(lottos)), manualLottos.size());
    }

    public LottoStatusResponseDto buyStatus() {
        return new LottoStatusResponseDto(lottos, manualCount);
    }

    public LottoResults matchWinningLotto(WinningLotto winningNumbers) {
        return lottos.matchWinningLotto(winningNumbers);
    }
}
