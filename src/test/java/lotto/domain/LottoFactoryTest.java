package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-06
 */
class LottoFactoryTest {

    @Test
    void 생성() {
        LottoFactory lottoFactory = new LottoFactory();
        Deque<Integer> lottoNumbers = new ArrayDeque<>(List.of(1, 2, 3, 4, 5, 6));

        List<Lotto> lotto = lottoFactory.produces(() -> lottoNumbers.pop(), 1);

        assertThat(lotto.get(0)).isEqualTo(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));
    }
}