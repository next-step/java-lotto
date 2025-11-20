package lotto.domain;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @Test
    void 로또번호_3개_일치() {
        LottoNumber lottoNumber = new LottoNumber(1, 2, 3, 4, 5, 6);
        LottoResult lottoResult = lottoNumber.checkLottoNumber(
                List.of(new LottoNumber(13, 2, 33, 40, 1, 3)));
        assertThat(lottoResult.getLottoNumberResult().getFirst()).isEqualTo(new LottoNumberResult(LottoRank.FOURTH, 1));
    }

    @Test
    void 지난주_당첨번호_6개_미만() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(1, 2, 3, 4, 5));
    }

}