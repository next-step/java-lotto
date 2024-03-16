package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    @Test
    void 로또_생성_테스트() {
        // given
        final LottoAmount lottoAmount = new LottoAmount(2000);

        // when
        final List<Lotto> lottos = LottoFactory.create(lottoAmount);

        // then
        assertThat(lottos).hasSize(2);
    }
}
