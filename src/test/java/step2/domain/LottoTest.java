package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,6,1",
            "1,2,3,4,5",
            "1,2,3,4",
            "1,2,3,3,4,5",
            "1,2,3,4,5,46"})
    @DisplayName("가짜 로또를 구별할 수 있다")
    void lottoCanDetermineFakeLotto(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Lotto(input));
    }

}
