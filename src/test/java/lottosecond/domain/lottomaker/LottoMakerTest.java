package lottosecond.domain.lottomaker;

import lottosecond.domain.lotto.Lotto;
import lottosecond.domain.lotto.LottoCount;
import lottosecond.domain.lotto.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoMakerTest {

    @DisplayName("LottoCount에 맞는 개수의 로또를 생성하여 Lottos 객체를 만들어줍니다.")
    @Test
    void makeLottos() {
        // given
        LottoCount lottoCount = LottoCount.from(2, 4);
        LottoMaker lottoMaker = new LottoMaker(new TestLottoNumberGenerator());
        // when
        Lottos lottos = lottoMaker.makeLottos(lottoCount);
        // then
        Assertions.assertThat(lottos).isEqualTo(new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        )));
    }

    @DisplayName("Lotto 객체 한개를 만들어줍니다.")
    @Test
    void makeLotto() {
        // given
        LottoMaker lottoMaker = new LottoMaker(new TestLottoNumberGenerator());
        // when
        Lotto lotto = lottoMaker.makeLotto();
        // then
        Assertions.assertThat(lotto).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

}