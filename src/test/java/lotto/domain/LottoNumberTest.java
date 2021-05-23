package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @Test
    @DisplayName("로또번호 기본생성")
    void create() {
        // given when then
        for (int i = 1; i <=45 ; i++) {
            LottoNumber lottoNumber = LottoNumber.of(i);
            assertThat(lottoNumber.number()).isEqualTo(i);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("로또번호 - 범위를 초과하는 경우")
    void create_outOfRange(int param) {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(param))
                .withMessageMatching("로또 숫자는 1과 45사이의 정수 이어야 합니다.");
    }

    @Test
    @DisplayName("전체 값 조회")
    void ofAll() {
        // given when
        List<LottoNumber> lottoNumbers = LottoNumber.ofAll();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(45);
    }
}