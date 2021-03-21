package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoWinnersTest {

    private String inputNumber = "1,2,3,4,5,6";
    private int bonusNumber = 45;

    @Test
    @DisplayName("당첨 번호 관리 생성 테스트")
    public void createWinnersTest() throws Exception {
        //given
        LottoWinners winners = LottoMachine.createWinners(inputNumber, bonusNumber);
        LottoWinners winners2 = LottoMachine.createWinners(inputNumber, bonusNumber);

        //when

        //then
        assertThat(winners2.equals(winners)).isTrue();
    }

    @Test
    @DisplayName("당첨번호와 보너스번호 중복 테스트")
    public void winnerNumberMatchOfBonusExceptionTest() throws Exception {
        //given

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
           LottoMachine.createWinners(inputNumber, 1);
        });

        //then
    }
}
