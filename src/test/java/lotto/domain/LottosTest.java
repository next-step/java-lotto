package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        this.lottos = new Lottos(Arrays.asList(
                new LottoNumbers(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )),
                new LottoNumbers(Arrays.asList(
                        new LottoNumber(7),
                        new LottoNumber(8),
                        new LottoNumber(9),
                        new LottoNumber(10),
                        new LottoNumber(11),
                        new LottoNumber(12)
                ))
        ));
    }

    @Nested
    class length_메서드는 {

        @Test
        void 길이를_리턴한다() {
            assertThat(lottos.length()).isEqualTo(2);
        }
    }

    @Nested
    class findMatch_메서드는 {

        @Test
        void 일치하는_숫자_개수를_리턴한다() {
            List<Integer> actual = lottos.findMatch("3, 4, 5, 6, 7, 8");

            assertThat(actual).containsExactly(4, 2);
        }
    }
}
