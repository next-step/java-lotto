package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-14
 */
class LottoNumbersTest {

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

        List<Integer> limited = lottoNumberPool.get()
                .stream()
                .limit(6)
                .collect(Collectors.toList());

        assertThat(limited).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}