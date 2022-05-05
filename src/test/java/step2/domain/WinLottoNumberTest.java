package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.service.LottoGameService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoNumberTest {
    @DisplayName("로또 당첨번호는 empty 거나 null 이 아니어야 한다")
    @ParameterizedTest
    @NullAndEmptySource
    void pickLottoNumberOfWeekEmptyOrNullTest(String input) {
        assertThatThrownBy(() -> {
            WinLottoNumber winLottoNumber = new WinLottoNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 당첨번호가 비어있습니다");
    }

    @DisplayName("로또 당첨번호는 6개이다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "3,2,1", "3,4","1", "1,2,3,4,5,6,7"})
    void pickLottoNumberOfWeekNumberCountTest(String input) {
        assertThatThrownBy(() -> {
            WinLottoNumber winLottoNumber = new WinLottoNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 당첨번호는 6개이다");
    }

    @DisplayName("로또 당첨번호는 중복을 허용하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"3,3,3,2,1,4", "2,4,5,6,7,2", "1,1,1,1,1,1","2,3,4,5,6,6"})
    void pickLottoNumberOfWeekDuplicateTest(String input) {
        assertThatThrownBy(() -> {
            WinLottoNumber winLottoNumber = new WinLottoNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 당첨번호는 유니크 합니다");
    }

    @DisplayName("로또 당첨번호 추출")
    @Test
    void pickLottoNumberOfWeekTest() {
        WinLottoNumber winLottoNumber = new WinLottoNumber("10, 2, 3, 4, 5, 6");
        assertThat(winLottoNumber.pickLottoNumberOfWeek())
                .containsExactly(10, 2, 3, 4, 5, 6);
    }

}