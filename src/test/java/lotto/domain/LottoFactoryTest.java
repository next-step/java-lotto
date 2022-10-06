package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-06
 */
class LottoFactoryTest {

    @Test
    void 생성() {
        LottoFactory lottoFactory = new LottoFactory(() -> List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = lottoFactory.produce();

        assertThat(lotto.getLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}