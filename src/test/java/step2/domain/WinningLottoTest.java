package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    WinningLotto winningLotto;
    Lotto  lotto;

    @BeforeEach
    void init() {
        winningLotto = WinningLotto.create("1, 2, 3, 4, 5, 6", "45");
        lotto = Lotto.create("1, 2, 3, 4, 45, 6");
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호가 중복일 경우 체크")
    void bonusNumberCheck() {
        assertThrows(IllegalArgumentException.class, () -> WinningLotto.create("1, 2, 3, 4, 45, 6", "45"));
    }

    @Test
    @DisplayName("로또 번호 비교후 등수 체크")
    void matchNumber() {
        assertEquals(winningLotto.match(lotto), Rank.SECOND);
    }
}