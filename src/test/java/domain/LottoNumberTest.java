package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
            "41", "42", "43", "44", "45"
    })
    @DisplayName("정상 번호로 로또 번호 생성")
    void createSuccess(String input) {
        assertThat(new LottoNumber(input))
                .isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0", "46", "-1", "a", "1.1", "1.0", "-", "99"
    })
    @DisplayName("비정상 번호 입력로 로또 번호 생성")
    void createFail(String input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid");
    }

    @Test
    @DisplayName("로또 번호 비교")
    void compareTo() {
        assertThat(new LottoNumber(1).compareTo(new LottoNumber(2)))
                .isEqualTo(-1);
        assertThat(new LottoNumber(2).compareTo(new LottoNumber(1)))
                .isEqualTo(1);
        assertThat(new LottoNumber(1).compareTo(new LottoNumber(1)))
                .isEqualTo(0);
    }
}