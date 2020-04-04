package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {
    List<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또티켓 한장에는 중복되지 않는 6개의 로또번호가 들어간다.")
    @Test
    void oneLotto() {
        assertThat(new Lotto(lottoNumbers).size()).isEqualTo(6);
    }

    @DisplayName("중복된 숫자가 포함되어 있을 경우 에러발생")
    @Test
    void duplicatedNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    List<Integer> lottoNumbers =
                            Arrays.asList(1, 2, 2, 4, 5, 6);
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("숫자가 총 6개가 아니면 에러발생")
    @Test
    void sixNumbers() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5);
                    new Lotto(lottoNumbers);
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    List<Integer> lottoNumbers =
                            Arrays.asList(1, 2, 3, 4, 5, 6, 7);
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("당첨번호를 입력하면 몇등인지 알 수 있다.")
    @Test
    void rank() {
        Lotto lotto = new Lotto(lottoNumbers);
        LottoWinningNumber lottoWinningNumber =
                new LottoWinningNumber(lottoNumbers, 45);
        assertThat(lotto.rank(lottoWinningNumber)).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("로또티켓 한장은 천원이다.")
    @Test
    void price() {
        assertThat(Lotto.PRICE).isEqualTo(1000);
    }
}
