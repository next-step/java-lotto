package step2.dto;

import step2.domain.lotto.Lottos;
import step2.exception.ListNullPointerException;

public final class LottoExpressionResponseDto {

    private final Lottos lottos;

    private LottoExpressionResponseDto(Lottos lottos) {
        if (isNull(lottos)) {
            throw new ListNullPointerException();
        }
        this.lottos = lottos;
    }

    public static final LottoExpressionResponseDto newInstance(Lottos lottos) {
        return new LottoExpressionResponseDto(lottos);
    }

    private final boolean isNull(Lottos lottos) {
        return lottos == null;
    }

    public final Lottos getLottoList() {
        return lottos;
    }

}
