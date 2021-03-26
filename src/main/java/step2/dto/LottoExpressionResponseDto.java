package step2.dto;

import step2.domain.Lotto.LottoList;
import step2.exception.LottoListNullPointerException;

import java.util.Objects;

public final class LottoExpressionResponseDto {

    private final LottoList lottoList;

    private LottoExpressionResponseDto(LottoList lottoList) {
        if (isNull(lottoList)) {
            throw new LottoListNullPointerException();
        }
        this.lottoList = lottoList;
    }

    public static final LottoExpressionResponseDto newInstance(LottoList lottoList) {
        return new LottoExpressionResponseDto(lottoList);
    }

    private final boolean isNull(LottoList lottoList) {
        return lottoList == null;
    }

    public final LottoList getLottoList() {
        return lottoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoExpressionResponseDto that = (LottoExpressionResponseDto) o;
        return Objects.equals(lottoList, that.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }
}
