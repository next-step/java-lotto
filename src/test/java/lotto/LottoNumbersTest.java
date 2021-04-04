package lotto;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    LottoNumbers lottoNumbers;

    @Test
    @DisplayName("로또 1장의 가격은 1000원이다.\n" +
            "14000원을 건네면 14개")
    void price() {
        assertThat(lottoNumbers.lottoCount(14000))
                .isEqualTo(14); //Q: 잔돈이나, 금액 부족한거는 어쩌지? 요구사항에 없으니 일단 pass
    }

    @Test
    @DisplayName("숫자가 맞으면 1을 더해준다")
    void contains() {
        assertThat(lottoNumbers.contains(10, 5)).isEqualTo(6);
    }

    @Test
    @DisplayName("로또수동검증")
    void manual() {
        lottoNumbers.mark(Arrays.asList(8, 21, 23, 41, 42, 43));
        assertThat(lottoNumbers.contains(8)).isTrue();
        assertThat(lottoNumbers.contains(21)).isTrue();
        assertThat(lottoNumbers.contains(23)).isTrue();
        assertThat(lottoNumbers.contains(41)).isTrue();
        assertThat(lottoNumbers.contains(42)).isTrue();
        assertThat(lottoNumbers.contains(43)).isTrue();
        assertThat(lottoNumbers.contains(44)).isFalse();
        lottoNumbers.mark(Arrays.asList(3, 5, 11, 16, 32, 38));
        assertThat(lottoNumbers.contains(3)).isTrue();
        assertThat(lottoNumbers.contains(5)).isTrue();
        assertThat(lottoNumbers.contains(11)).isTrue();
        assertThat(lottoNumbers.contains(16)).isTrue();
        assertThat(lottoNumbers.contains(32)).isTrue();
        assertThat(lottoNumbers.contains(38)).isTrue();
        assertThat(lottoNumbers.contains(40)).isFalse();
        lottoNumbers.mark(Arrays.asList(7, 11, 16, 35, 36, 44));
        assertThat(lottoNumbers.contains(7)).isTrue();
        assertThat(lottoNumbers.contains(11)).isTrue();
        assertThat(lottoNumbers.contains(16)).isTrue();
        assertThat(lottoNumbers.contains(35)).isTrue();
        assertThat(lottoNumbers.contains(36)).isTrue();
        assertThat(lottoNumbers.contains(44)).isTrue();
        assertThat(lottoNumbers.contains(50)).isFalse();
    }

    @BeforeEach
    void init() {
        lottoNumbers = new LottoNumbers();
    }
}
