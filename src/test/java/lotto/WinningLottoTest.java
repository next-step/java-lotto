package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static lotto.domain.Lotto.SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
@Nested
@DisplayName("WinningLottoTest 클래스는")
public class WinningLottoTest {

    @Test
    @DisplayName("보너스볼과 당첨번호의 중복 테스트")
    void bonusBallDuplicateCheckTest() {
        assertThatThrownBy(() ->
        {
            WinningLotto winningLotto = WinningLotto.ofStringAndBonusBall("1,2,3,4,5,6", LottoNumber.ofInt(6));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("당첨 번호와 보너스볼이 겹칩니다.");
    }

    @Test
    @DisplayName("당첨번호 Number로 변환 테스트")
    void parseIntWinningLottoTest() {
        assertThatThrownBy(() ->
        {
            WinningLotto winningLotto = WinningLotto.ofStringAndBonusBall("1,2,3,4,5$6", LottoNumber.ofInt(6));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("당첨 번호가 NUMBER로 변환 불가능 합니다.");
    }

    @Nested
    @DisplayName("checkSize 메소드는")
    class Describe_checkSize{
        @Nested
        @DisplayName("입력된 당첨번호의 길이가 SIZE 보다 클 때")
        class long_winningLotto_size_test{
            @Test
            @DisplayName("IllegalArgumentException 발생")
            void long_winningLotto_size_test() {
                assertThatThrownBy(() ->
                {
                    WinningLotto winningLotto = WinningLotto.ofStringAndBonusBall("1,2,3,4,5,6,7", LottoNumber.ofInt(12));
                }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 winningLotto 는 입력될 수 없습니다.");
            }
        }
        @Nested
        @DisplayName("입력된 당첨번호의 길이가 SIZE 보다 작을 때")
        class short_winningLotto_size_test{
            @Test
            @DisplayName("IllegalArgumentException 발생")
            void short_winningLotto_size_test() {
                assertThatThrownBy(() ->
                {
                    WinningLotto winningLotto = WinningLotto.ofStringAndBonusBall("1,2,3,4,5", LottoNumber.ofInt(6));
                }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 winningLotto 는 입력될 수 없습니다.");
            }
        }
    }

    @Test
    @DisplayName("당첨 번호가 해당 로또넘버를 포함하는지 checkContainNumber 테스트")
    void checkContainNumberTest() {
        WinningLotto winningLotto = WinningLotto.ofString("1,2,3,4,5,6");
        assertTrue(winningLotto.checkContainNumber(LottoNumber.ofInt(5)));
        assertFalse(winningLotto.checkContainNumber(LottoNumber.ofInt(12)));
    }
}
