package step2.dto;

import step2.domain.Lotto.LottoList;

public class LottoExpressionResponseDto {
    private final LottoList lottoList;

    private LottoExpressionResponseDto(LottoList lottoList) {
        this.lottoList = lottoList;
    }
    public static LottoExpressionResponseDto newInstance(LottoList lottoList) {
        return new LottoExpressionResponseDto(lottoList);
    }
}
