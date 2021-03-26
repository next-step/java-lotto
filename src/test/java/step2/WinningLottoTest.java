package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    @DisplayName("지난 주 당첨번호 생성 테스트")
    void create_last_winning_lotto(){
        String input = "1,2,3,4,5,6";
        WinningLotto winningLotto = new WinningLotto(input);
        assertThat(winningLotto.getLottoNumberList().size()).isEqualTo(6);
    }

}
