package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-14
 */
class LottoNumberPoolTest {

    @Test
    void 생성() {
        LottoNumberPool lottoNumberPool = new LottoNumberPool();

        assertThat(lottoNumberPool).isEqualTo(new LottoNumberPool());
    }

    @Test
    void 섞기() {
        LottoNumberPool lottoNumberPool = new LottoNumberPool();

        lottoNumberPool.shuffle(numbers -> {
        });

        List<Integer> limited = lottoNumberPool.getRandomNumbers(6);

        assertThat(limited).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}