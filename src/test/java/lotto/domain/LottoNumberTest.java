package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 번호 인스턴스 비교 테스트1")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 로또_번호_인스턴스_비교_성공_테스트_1(int number) {
        assertThat(LottoNumber.valueOf(number) == LottoNumber.valueOf(Integer.toString(number))).isTrue();
    }

    @ParameterizedTest
    @DisplayName("로또 번호 인스턴스 비교 테스트2")
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void 로또_번호_인스턴스_비교_성공_테스트_2(String strNumber) {
        assertThat(LottoNumber.valueOf(strNumber) == LottoNumber.valueOf(strNumber + " ")).isTrue();
    }

}
