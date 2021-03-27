package step2.controller;

import step2.domain.generator.LottoGenerator;
import step2.domain.lotto.LottoList;
import step2.dto.LottoCreationRequestDto;
import step2.dto.LottoExpressionResponseDto;
import step2.strategy.LottoRandomShuffleStrategy;
import step2.strategy.LottoShuffleStrategy;

public final class LottoController {

    private final LottoShuffleStrategy strategy;
    private final LottoList lottoList;

    private LottoController() {
        this(LottoRandomShuffleStrategy.getInstance());
    }

    private LottoController(LottoShuffleStrategy strategy) {
        this.strategy = strategy;
        this.lottoList = LottoList.newInstance();
    }

    public static final LottoController newInstance() {
        return new LottoController();
    }

    public static final LottoController newInstance(LottoShuffleStrategy strategy) {
        return new LottoController(strategy);
    }

    public final LottoExpressionResponseDto generateLottoList(LottoCreationRequestDto creationRequestDto) {
        LottoGenerator lottoGenerator = LottoGenerator.newInstance(creationRequestDto, strategy);
        while (lottoGenerator.hasNext()) {
            lottoList.add(lottoGenerator.generateLotto());
            lottoGenerator.next();
        }
        return LottoExpressionResponseDto.newInstance(lottoList);
    }

}
