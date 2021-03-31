package step2.controller;

import step2.domain.checker.LottoWinningChecker;
import step2.domain.generator.LottoGenerateCount;
import step2.domain.generator.LottoGenerator;
import step2.domain.lotto.Lottos;
import step2.dto.LottoWinningCheckRequestDto;
import step2.dto.LottoCreationRequestDto;
import step2.dto.LottoExpressionResponseDto;
import step2.dto.LottoWinningResultResponseDto;
import step2.strategy.LottoRandomShuffleStrategy;
import step2.strategy.LottoShuffleStrategy;

public final class LottoController {

    private final Lottos lottos;
    private final LottoShuffleStrategy strategy;

    private LottoController() {
        this(LottoRandomShuffleStrategy.getInstance());
    }

    private LottoController(LottoShuffleStrategy strategy) {
        this.lottos = Lottos.newInstance();
        this.strategy = strategy;
    }

    public static final LottoController newInstance() {
        return new LottoController();
    }

    public static final LottoController newInstance(LottoShuffleStrategy strategy) {
        return new LottoController(strategy);
    }

    public final LottoExpressionResponseDto getExpressionLottoList(LottoCreationRequestDto creationRequestDto) {
        LottoGenerateCount lottoGenerateCount = LottoGenerateCount.of(creationRequestDto);
        LottoGenerator lottoGenerator = LottoGenerator.of(strategy);
        while (lottoGenerateCount.hasNext()) {
            lottos.add(lottoGenerator.generateLotto());
            lottoGenerateCount.next();
        }
        return LottoExpressionResponseDto.newInstance(lottos);
    }

    public final LottoWinningResultResponseDto getWinningResult(LottoWinningCheckRequestDto confirmationRequestDto) {
        LottoWinningChecker winningChecker = LottoWinningChecker.of(confirmationRequestDto);
        return winningChecker.getLottoWinningResultResponseDto(lottos);
    }

}
