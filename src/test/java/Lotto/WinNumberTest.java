package Lotto;

import lotto.domain.WinNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinNumberTest {

    @Test
    @DisplayName("당첨번호를 제대로 입력받는지 확인")
    public void get_win_number(){

        WinNumbers winNumbers = new WinNumbers("1 , 4 , 5, 23, 43, 45");
        Assertions.assertThat(winNumbers.getWinNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨번호를 제대로 입력못했을때 예외")
    public void get_win_number_exception(){

        Assertions.assertThatIllegalStateException().isThrownBy(
                ()->{
                    new WinNumbers("1 , 4 , 5, 23, 43");;}
        );
    }
}
