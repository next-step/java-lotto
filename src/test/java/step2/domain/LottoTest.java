package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LottoTest {

    Lotto lotto;

    @BeforeEach
    public void init() {
        lotto = Lotto.create("1, 2, 3, 4, 5, 6");
    }

    @Test
    @DisplayName("로또 번호 갯수 체크")
    public void checkLottoNumberCnt() {
        assertThrows(IllegalArgumentException.class, () -> Lotto.create("1, 2, 3, 4, 5"));
    }

    @Test
    @DisplayName("로또 등수 체크")
    public void containLottoNumberCheck() {
        WinningLotto winningLotto = WinningLotto.create("1, 3, 4, 5, 6, 7", "45");
        assertEquals(lotto.match(winningLotto), Rank.SECOND);
    }
}
