package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @DisplayName("로또는 6개의 번호로 구성")
    @Test
    void create() {
        assertThatCode(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6))).doesNotThrowAnyException();
    }

    @DisplayName("로또 번호 중복시 에러")
    @Test
    void duplicatedNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 5)));
    }

    @DisplayName("로또 번호 6개가 아닐시 에러")
    @Test
    void invalidSize() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @DisplayName("콤마 구분 문자열로 로또 생성")
    @Test
    void ofComma() {
        Lotto lotto = Lotto.of(
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
        assertThat(Lotto.ofComma("1,2,3,4,5,6")).isEqualTo(lotto);
    }

    @DisplayName("다른 로또와 당첨 비교")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,7:5"}, delimiter = ':')
    void matchAll(String lottoNumbers, int expected) {
        Lotto winningLotto = Lotto.ofComma("1,2,3,4,5,6");
        Lotto buyLotto = Lotto.ofComma(lottoNumbers);

        assertThat(winningLotto.match(buyLotto)).isEqualTo(expected);
    }

    @DisplayName("로또 번호 포함")
    @ParameterizedTest
    @CsvSource({"1,true", "7,false"})
    void contains(int number, boolean expected) {
        Lotto lotto = Lotto.ofComma("1,2,3,4,5,6");
        LottoNumber lottoNumber = LottoNumber.of(number);

        assertThat(lotto.contains(lottoNumber)).isEqualTo(expected);
    }

}
