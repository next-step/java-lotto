package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameTest {
    private List<LottoNumber> winningNumbers;
    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    public void setup() {
        lottoNumbers = Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
    }

    @Test
    public void match_6개_테스트() {
        winningNumbers = Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));

        Assertions.assertThat(LottoGame.match(lottoNumbers, winningNumbers)).isEqualTo(6);
    }

    @Test
    public void match_3개_테스트() {
        winningNumbers = Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(7),
                new LottoNumber(8),
                new LottoNumber(9));

        assertThat(LottoGame.match(lottoNumbers, winningNumbers)).isEqualTo(3);
    }

    @Test
    public void invalidWinningNumbersThrowException() {
        winningNumbers = Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoGame.match(lottoNumbers, winningNumbers);
        });
    }
}
