package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        this.lottoNumbers = LottoNumbers.of(
            List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)));
    }

    @Test
    @DisplayName("로또 번호는 6개이다.")
    void count() {
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다.")
    void duplicate() {
        assertThatThrownBy(() -> LottoNumbers.of(
            List.of(LottoNumber.from(1), LottoNumber.from(1), LottoNumber.from(1),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)))).isInstanceOf(
            IllegalArgumentException.class);
    }
}
