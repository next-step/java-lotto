package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyLottosTest {

    private Lotto lotto_123456;
    private Lotto lotto_123457;


    @BeforeEach
    void setup() {
        lotto_123456 = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto_123457 = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7));
    }

    @Test
    @DisplayName("로또다수/넣은로또만큼/생성된다.")
    void 로또를_여러개_생성한다() {
        // when
        MyLottos myLottos = new MyLottos(List.of(lotto_123456, lotto_123457));

        // then
        assertThat(myLottos.getLottos()).hasSize(2);
    }

    @Test
    @DisplayName("결과확인/winningLotto를 넣는다/결과가 나온다.")
    void 로또의_결과를_확인한다() {
        // given
        MyLottos myLottos = new MyLottos(List.of(lotto_123456, lotto_123457));
        WinningLotto winningLotto = new WinningLotto(lotto_123456, 30);

        // when
        LottoResult lottoResult = myLottos.getLottoResult(winningLotto);

        // then
        assertThat(lottoResult.getPrizeCount(LottoPrize.FIRST)).isEqualTo(1);
    }
}