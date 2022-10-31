package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-12
 */
class LottoFactoryTest {

    @Test
    void 생성_자동() {
        LottoFactory lottoFactory = new LottoFactory();

        List<Lotto> produces = lottoFactory.produceAutoLottos((lottoNumbers) -> {
        }, 2);

        assertThat(produces).hasSize(2);
        assertThat(produces.get(0)).isEqualTo((Lotto.ofInteger(List.of(1, 2, 3, 4, 5, 6))));
    }

    @Test
    void 생성_수동() {
        LottoFactory lottoFactory = new LottoFactory();

        List<Lotto> produces = lottoFactory.produceManualLottos(List.of("1,2,3,4,5,6", "1,2,3,4,5,6"));

        assertThat(produces).hasSize(2);
        assertThat(produces.get(0)).isEqualTo((Lotto.ofInteger(List.of(1, 2, 3, 4, 5, 6))));
    }
}