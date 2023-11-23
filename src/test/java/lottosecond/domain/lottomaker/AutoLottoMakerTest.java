package lottosecond.domain.lottomaker;

import lottosecond.domain.lotto.Lotto;
import lottosecond.domain.lotto.LottoCount;
import lottosecond.domain.lotto.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class AutoLottoMakerTest {

    @DisplayName("LottoCount에 맞는 개수의 로또를 생성하여 Lottos 객체를 만들어줍니다.")
    @Test
    void makeLottos() {
        // given
        LottoCount lottoCount = LottoCount.from(2, 4);
        AutoLottoMaker lottoMaker = new AutoLottoMaker(new TestLottoNumberGenerator());
        // when
        Lottos lottos = lottoMaker.makeLottos(lottoCount);
        // then
        Assertions.assertThat(lottos).isEqualTo(new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        )));
    }
}