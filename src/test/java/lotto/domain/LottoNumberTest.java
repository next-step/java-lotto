package lotto.domain;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("로또 번호 1, 45 정상 생성")
    @Test
    void create() {
        LottoNumber number = LottoNumber.of(1);
        assertThat(LottoNumber.of(1)).isEqualTo(number);
    }

    @DisplayName("로또 번호 범위를 벗어난 경우 에러")
    @ParameterizedTest
    @CsvSource({"0", "46"})
    void outOfRange(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(number));
    }
}
