package step2.controller;

import step2.domain.Lotto.LottoGenerateCount;
import step2.domain.Lotto.LottoGenerator;
import step2.domain.Lotto.LottoList;
import step2.dto.LottoCreationRequestDto;
import step2.dto.LottoExpressionResponseDto;
import step2.strategy.LottoRandomShuffleStrategy;
import step2.strategy.LottoShuffleStrategy;

public final class LottoController {

    private final LottoGenerateCount lottoGenerateCount;
    private final LottoGenerator lottoGenerator;

    private LottoController(LottoCreationRequestDto creationRequestDto) {
        this(creationRequestDto, LottoRandomShuffleStrategy.getInstance());
    }

    private LottoController(LottoCreationRequestDto creationRequestDto, LottoShuffleStrategy strategy) {
        this.lottoGenerateCount = LottoGenerateCount.newInstance(creationRequestDto);
        this.lottoGenerator = LottoGenerator.newInstance(strategy);
    }

    public static final LottoController newInstance(LottoCreationRequestDto creationRequestDto) {
        return new LottoController(creationRequestDto);
    }

    public static final LottoController newInstance(LottoCreationRequestDto creationRequestDto, LottoShuffleStrategy strategy) {
        return new LottoController(creationRequestDto, strategy);
    }

    public final LottoExpressionResponseDto generateLottoList() {
        LottoList lottoList = LottoList.newInstance();
        while (lottoGenerateCount.hasNext()) {
            lottoList.add(lottoGenerator.generateLotto());
            lottoGenerateCount.next();
        }
        return LottoExpressionResponseDto.newInstance(lottoList);
    }

}
