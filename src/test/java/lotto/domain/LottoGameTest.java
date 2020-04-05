package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private Lotto winningNumbers;
    private Lotto lottoNumbers;

    @BeforeEach
    public void setup() {
        lottoNumbers = new Lotto(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));
    }

    @Test
    public void match_6개_테스트() {
        winningNumbers = new Lotto(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        Assertions.assertThat(LottoGame.match(lottoNumbers, winningNumbers)).isEqualTo(Rank.valueOf(6));
    }

    @Test
    public void match_3개_테스트() {
        winningNumbers = new Lotto(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(7),
                new LottoNumber(8),
                new LottoNumber(9)));

        assertThat(LottoGame.match(lottoNumbers, winningNumbers)).isEqualTo(Rank.valueOf(3));
    }
}
