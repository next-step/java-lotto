package step3.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    WinningLotto winningLotto;
    UserLotto userLotto;

    @BeforeEach
    void setUp() {
        winningLotto = WinningLotto.of(new LottoNumber(Arrays.asList(1, 2, 4, 8, 16, 32)), 45);
    }

    @Test
    void 매칭_되는_개수_확인_테스트() {
        LottoNumber lottoNumberA = new LottoNumber(List.of(32, 8, 16, 1, 4, 2));
        LottoNumber lottoNumberB = new LottoNumber(List.of(3, 2, 5, 8, 16, 33));

        userLotto = new UserLotto(List.of(lottoNumberA, lottoNumberB));
        assertThat(winningLotto.findCountOfMatch(lottoNumberA)).isEqualTo(6);
        assertThat(winningLotto.findCountOfMatch(lottoNumberB)).isEqualTo(3);
    }
}
