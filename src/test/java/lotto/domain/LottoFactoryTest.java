package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-12
 */
class LottoFactoryTest {

    @Test
    void 생성() {
        LottoFactory lottoFactory2 = new LottoFactory();

        List<Lotto> produces = lottoFactory2.produces((lottoNumbers) -> {}, 2);

        assertThat(produces).hasSize(2);
        assertThat(produces).contains(Lotto.of(List.of(1,2,3,4,5,6)));
    }
}