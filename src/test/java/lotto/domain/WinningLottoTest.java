package lotto.domain;


import lotto.domain.constant.LottoRank;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    void 로또번호_3개_일치() {
        WinningLotto lottoNumber = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 30);
        LottoResult lottoResult = lottoNumber.checkLottoNumber(
                new BuyLotto(13, 2, 33, 40, 1, 3));
        assertThat(lottoResult.getLottoNumberResult().getFirst()).isEqualTo(new LottoNumberResult(LottoRank.FIFTH, 1));
    }

    @Test
    void 지난주_당첨번호_6개_미만() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(1, 2, 3, 4, 5));
    }

    @Test
    void 로또번호_5개_보너스번호_일치() {
        WinningLotto lottoNumber = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoResult lottoResult = lottoNumber.checkLottoNumber(new BuyLotto(1, 2, 3, 4, 5, 7));
        // [FOURTH(0), THIRD(0), SECOND(0), BONUS(1), FIRST(0)]
        assertThat(lottoResult.getLottoNumberResult().get(3)).isEqualTo(new LottoNumberResult(LottoRank.SECOND, 1));
    }

}