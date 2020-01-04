package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", 7);

        LottoBundle lottoBundle = LottoBundle.of(
                Arrays.asList(
                        Lotto.of("1,2,3,4,5,6"),
                        Lotto.of("2,3,4,5,6,7"),
                        Lotto.of("3,4,5,6,7,8"),
                        Lotto.of("4,5,6,7,8,9")
                )
        );

        lottoResult = new LottoResult();
        lottoResult.match(lottoBundle, winningLotto);
    }

    @Test
    void 제대로_매치가_되는지_확인한다() {
        assertThat(lottoResult.getCount(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getCount(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.getCount(Rank.THIRD)).isEqualTo(0);
        assertThat(lottoResult.getCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.getCount(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    void 수익이_맞는지_확인한다() {
        assertThat(lottoResult.getAmount()).isEqualTo(2030055000);
    }
}
