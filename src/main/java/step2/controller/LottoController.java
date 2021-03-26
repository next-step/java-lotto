package step2.controller;

import step2.domain.Lotto.Lotto;
import step2.domain.Lotto.LottoGenerateCount;
import step2.domain.Lotto.LottoGenerator;
import step2.domain.Lotto.LottoList;
import step2.dto.LottoCreationRequestDto;
import step2.dto.LottoExpressionResponseDto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {


    private LottoController() {
    }

    public static LottoController newInstance() {
        return new LottoController();
    }

    public LottoExpressionResponseDto generateLottoList(LottoCreationRequestDto creationRequestDto) {
        LottoGenerateCount lottoGenerateCount = LottoGenerateCount.newInstance(creationRequestDto.getInputMoney());
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();
        LottoList lottoList = LottoList.newInstance();
        while (lottoGenerateCount.hasNext()) {
            lottoList.add(lottoGenerator.generateLotto());
            lottoGenerateCount.next();
        }
        return LottoExpressionResponseDto.newInstance(lottoList);
    }
}
