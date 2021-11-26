package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.Lotto.SIZE;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class WinningLottoTest {

    @Test
    @DisplayName("보너스볼과 당첨번호의 중복 테스트")
    void bonusBallDuplicateCheckTest() {
        assertThatThrownBy(() ->
        {
            WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", new LottoNumber(6));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("당첨 번호와 보너스볼이 겹칩니다.");
    }

    @Test
    @DisplayName("보너스볼과 당첨번호의 중복 테스트")
    void parseIntWinningLottoTest() {
        assertThatThrownBy(() ->
        {
            WinningLotto winningLotto = new WinningLotto("1,2,3,4,5$6", new LottoNumber(6));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("당첨 번호가 NUMBER로 변환 불가능 합니다.");
    }

    @Test
    @DisplayName("입력된 당첨번호의 길이가 SIZE 와 다를 때 exception 테스트")
    void checkSizeTest() {
        assertThatThrownBy(() ->
        {
            WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6,7", new LottoNumber(6));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 winningLotto 는 입력될 수 없습니다.");
        assertThatThrownBy(() ->
        {
            WinningLotto winningLotto = new WinningLotto("1,2,3,4,5", new LottoNumber(6));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 winningLotto 는 입력될 수 없습니다.");
    }

    @Test
    @DisplayName("당첨 번호의 size 테스트")
    void checkContainNumberTest() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        assertTrue(winningLotto.checkContainNumber(new LottoNumber(5)));
        assertFalse(winningLotto.checkContainNumber(new LottoNumber(12)));
    }
}
