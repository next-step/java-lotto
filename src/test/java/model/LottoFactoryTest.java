package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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

    @Test
    void 수동_로또_생성_테스트() {
        // given
        final List<List<Integer>> numbers = List.of(List.of(1, 2, 3, 4, 5, 6), List.of(3, 4, 5, 6, 7, 8));

        // when
        final Lottos lottos = LottoFactory.create(numbers);

        // then
        assertThat(lottos.getLottos()).hasSize(2);
    }
}
