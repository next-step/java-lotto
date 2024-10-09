package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 로또 번호를 체크한다.
- 객체를 비교한다.
*/
public class LottoTest extends GlobalTest {

    @DisplayName("로또 번호를 체크한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    void checkNumTest(int num, boolean b) {
        Lotto lotto = createLotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto.confirmExistLottoNum(num)).isEqualTo(b);
    }

    @DisplayName("로또 번호를 체크한다.")
    @Test
    void equalsTest() {
        Lotto lotto = createLotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto).isEqualTo(createLotto(1, 2, 3, 4, 5, 6));
    }
}
