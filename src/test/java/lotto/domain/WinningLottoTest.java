package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    private List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5), new LottoNumber(6)
    );
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(lottoNumbers);
    }

    @Test
    void matchLottoNumber() {
        WinningLotto winningLotto = new WinningLotto(lotto);

        assertThat(Prize.FIRST).isSameAs(winningLotto.getPrizeMatch(lotto));
    }
}
