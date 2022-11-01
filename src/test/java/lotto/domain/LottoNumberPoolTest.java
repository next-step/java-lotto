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

        assertThat(lottoNumberPool.getRandomNumbers(1).get(0)).isEqualTo(LottoNumber.of(1));
    }

    @Test
    void 섞기() {
        LottoNumberPool lottoNumberPool = new LottoNumberPool();

        lottoNumberPool.shuffle(numbers -> {
        });

        List<LottoNumber> limited = lottoNumberPool.getRandomNumbers(6);

        assertThat(limited).isEqualTo(List.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));
    }
}