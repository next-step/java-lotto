package step2.controller;

import step2.domain.Lotto.LottoGenerateCount;
import step2.domain.Lotto.LottoGenerator;
import step2.domain.Lotto.LottoList;
import step2.dto.LottoCreationRequestDto;
import step2.dto.LottoExpressionResponseDto;
import step2.strategy.LottoRandomShuffleStrategy;
import step2.strategy.LottoShuffleStrategy;

public final class LottoController {

    private final LottoShuffleStrategy strategy;

    private LottoController() {
        this(LottoRandomShuffleStrategy.getInstance());
    }

    private LottoController(LottoShuffleStrategy strategy) {
        this.strategy = strategy;
    }

    public static final LottoController newInstance() {
        return new LottoController();
    }

    public static final LottoController newInstance(LottoShuffleStrategy strategy) {
        return new LottoController(strategy);
    }

    public final LottoExpressionResponseDto generateLottoList(LottoCreationRequestDto creationRequestDto) {
        LottoGenerator lottoGenerator = LottoGenerator.newInstance(creationRequestDto, strategy);
        LottoList lottoList = LottoList.newInstance();
        while (lottoGenerator.hasNext()) {
            lottoList.add(lottoGenerator.generateLotto());
            lottoGenerator.next();
        }
        return LottoExpressionResponseDto.newInstance(lottoList);
    }

}
