package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {

    @DisplayName("empty test")
    @Test
    void validateEmptyTest2() {
        assertThatThrownBy(() -> new Lotto(new HashSet<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("empty");
    }

    @DisplayName("로또 사이즈 테스트")
    @Test
    void validateSizeTest() {
        assertThatThrownBy(() -> new Lotto(new HashSet<>(Arrays
                .asList(new LottoNo(1)
                        , new LottoNo(2)
                        , new LottoNo(3)
                        , new LottoNo(4)
                        , new LottoNo(5)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not 6");
    }

    @DisplayName("0이하, 45이상 값 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 55, 0})
    void validateNumberRangeTest(int number) {
        assertThatThrownBy(() -> new Lotto(new HashSet<>(Arrays
                .asList(
                        new LottoNo(number)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 1~45");
    }

    @Test
    void matchTest() {
        Lotto lotto = new Lotto(new HashSet<>(Arrays
                .asList(new LottoNo(1)
                        , new LottoNo(2)
                        , new LottoNo(3)
                        , new LottoNo(4)
                        , new LottoNo(5)
                        , new LottoNo(9))));

        String[] inputs = "1,2,3,4,5,7".split(",");
        int bonus = 8;
        WinnerNumber winnerNumber = new WinnerNumber(inputs, bonus);

        assertThat(lotto.match(winnerNumber.getWinnerNumber()))
                .isEqualTo(5);

    }
}
