package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.Lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {
    @DisplayName("로또 한장에는 중복되지 않는 6개의 로또번호가 들어간다.")
    @Test
    void oneLotto() {
        int[] lottoNumbers = {1, 2, 3, 4, 5, 6};
        assertThat(new Lotto(lottoNumbers).size()).isEqualTo(6);
    }

    @DisplayName("중복된 숫자가 포함되어 있을 경우 에러발생")
    @Test
    void duplicatedNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    int[] lottoNumbers = {1, 2, 2, 4, 5, 6};
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("숫자가 총 6개가 아니면 에러발생")
    @Test
    void sixNumbers() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    int[] lottoNumbers = {1, 2, 3, 4, 5};
                    new Lotto(lottoNumbers);
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    int[] lottoNumbers = {1, 2, 3, 4, 5, 6, 7};
                    new Lotto(lottoNumbers);
                });
    }

    @DisplayName("로또 한장은 천원이다.")
    @Test
    void price() {
        assertThat(Lotto.PRICE).isEqualTo(1000);
    }
}
