package step2.service;

import step2.domain.checker.LottoWinningChecker;
import step2.domain.generator.LottoGenerateCount;
import step2.domain.generator.LottoGenerator;
import step2.domain.lotto.Lottos;
import step2.domain.request.Money;
import step2.strategy.LottoRandomShuffleStrategy;
import step2.strategy.LottoShuffleStrategy;

public final class LottoService {

    private final LottoShuffleStrategy strategy;

    private LottoService(LottoShuffleStrategy strategy) {
        this.strategy = strategy;
    }

    public static final LottoService of() {
        return of(LottoRandomShuffleStrategy.getInstance());
    }

    public static final LottoService of(LottoShuffleStrategy strategy) {
        return new LottoService(strategy);
    }

    public final Lottos getLottos(Money money) {
        LottoGenerateCount lottoGenerateCount = LottoGenerateCount.of(money);
        LottoGenerator lottoGenerator = LottoGenerator.from(strategy);
        return lottoGenerator.generateLottos(lottoGenerateCount);
    }
/*
    public final LottoWinningResultResponseDto getWinningResult(LottoWinningCheckRequestDto confirmationRequestDto) {
        LottoWinningChecker winningChecker = LottoWinningChecker.of(confirmationRequestDto);
        return winningChecker.getLottoWinningResultResponseDto(lottos);
    }
*/
}
