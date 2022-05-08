package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

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
    class getRevenueRate_메서드는 {

        @Test
        void 수익률을_리턴한다() {
            LottoNumbers lottoNumbers = new LottoNumbers("4, 5, 6, 7, 8, 9");

            double actual = lottos.getRevenueRate(lottoNumbers, new LottoNumber(10));

            assertThat(actual).isEqualTo(5.00, offset(0.01));
        }
    }

    @Nested
    class getRankCount_메서드는 {

        @Test
        void rank예_해당하는_개수를_리턴한다() {
            LottoNumbers lottoNumbers = new LottoNumbers("4, 5, 6, 7, 8, 9");
            LottoNumber bonusBall = new LottoNumber(10);
            WinningLotto winningLotto = new WinningLotto(lottoNumbers, bonusBall);

            int rankCount = lottos.getRankCount(winningLotto, Rank.FIFTH);

            assertThat(rankCount).isEqualTo(2);
        }
    }
}
