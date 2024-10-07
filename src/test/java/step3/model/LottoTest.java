package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 로또 번호를 체크한다.
- 객체를 비교한다.
*/
public class LottoTest {

    @DisplayName("로또 번호를 체크한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    void checkNumTest(int num, boolean b) {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.checkNum(num)).isEqualTo(b);
    }

    @DisplayName("로또 번호를 체크한다.")
    @Test
    void equalsTest() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isEqualTo(new Lotto(Set.of(1, 2, 3, 4, 5, 6)));
    }
}
