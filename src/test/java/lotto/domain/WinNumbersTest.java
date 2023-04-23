package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinNumbersTest {

    @Test
    @DisplayName("WinNumbers 생성")
    void test01() {
        WinNumbers winNumbers = new WinNumbers(1, 2, 3, 4, 5, 6);

        assertThat(winNumbers).isNotNull();
    }

    @Test
    @DisplayName("당첨 번호와, 로또가 3개 일치 하면 5등")
    void test02() {
        WinNumbers winNumbers = new WinNumbers(1, 2, 3, 4, 5, 6);

        WinType wintype = winNumbers.confirmWin(new Lotto(1, 2, 3, 40, 41, 42));

        assertThat(wintype).isEqualTo(WinType.FIFTH);
    }

    @Test
    @DisplayName("당첨 번호와, 로또가 4개 일치 하면 4등")
    void test03() {
        WinNumbers winNumbers = new WinNumbers(1, 2, 3, 4, 5, 6);

        WinType wintype = winNumbers.confirmWin(new Lotto(1, 2, 3, 4, 41, 42));

        assertThat(wintype).isEqualTo(WinType.FOURTH);
    }

    @Test
    @DisplayName("당첨 번호와, 로또가 5개 일치 하면 3등")
    void test04() {
        WinNumbers winNumbers = new WinNumbers(1, 2, 3, 4, 5, 6);

        WinType wintype = winNumbers.confirmWin(new Lotto(1, 2, 3, 4, 5, 42));

        assertThat(wintype).isEqualTo(WinType.THIRD);
    }

    @Test
    @DisplayName("당첨 번호와, 로또가 6개 일치 하면 1등")
    void test05() {
        WinNumbers winNumbers = new WinNumbers(1, 2, 3, 4, 5, 6);

        WinType wintype = winNumbers.confirmWin(new Lotto(1, 2, 3, 4, 5, 6));

        assertThat(wintype).isEqualTo(WinType.FIRST);
    }
}
