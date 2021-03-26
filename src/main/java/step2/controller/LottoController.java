package step2.controller;

import step2.dto.LottoCreationRequestDto;
import step2.dto.LottoExpressionResponseDto;

public class LottoController {

    private LottoController() {
    }

    public static LottoController newInstance() {
        return new LottoController();
    }

    public LottoExpressionResponseDto generateLottoList(LottoCreationRequestDto creationRequestDto) {


    }
}
