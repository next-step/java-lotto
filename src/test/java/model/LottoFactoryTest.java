package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    @Test
    void 로또_생성_테스트() {
        // given
        final int lottoCount = 3;

        // when
        final Lottos lottos = LottoFactory.create(lottoCount);

        // then
        assertThat(lottos.getLottos()).hasSize(3);
    }
}
