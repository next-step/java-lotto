package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @DisplayName("1~45 사이의 로또번호 생성")
    @ParameterizedTest
    @ValueSource(ints = {1,15,30,45})
    void lottoNumber_로또번호_생성(int input) {
        assertThat(new LottoNumber(input)).isInstanceOf(LottoNumber.class);
    }

    @DisplayName("번호가 1~45 사이가 아닐때 예외 throw")
    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 46})
    void lottoNumber_범위를_벗어난_번호(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(input);
        }).withMessageMatching("1부터 45 사이의 숫자를 등록해야 합니다.");
    }

    @DisplayName("입력한 번호와 같을 경우 true")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "7:7", "15:15", "37:37"}, delimiter = ':')
    void getLottoNumber_입력한_번호와_같을_경우_true(int input, int compareNUmber) {
        assertThat(new LottoNumber(input).isEqualsNumber(compareNUmber)).isTrue();
    }

    @DisplayName("입력한 번호와 다를 경우 false")
    @ParameterizedTest
    @CsvSource(value = {"1:10", "7:8", "15:20", "37:40"}, delimiter = ':')
    void getLottoNumber_입력한_번호와_다를_경우_false(int input, int compareNUmber) {
        assertThat(new LottoNumber(input).isEqualsNumber(compareNUmber)).isFalse();
    }


}
