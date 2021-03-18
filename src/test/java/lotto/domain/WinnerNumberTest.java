package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinnerNumberTest {
    private String inputWinners;

    @BeforeEach
    public void setUp() {
        inputWinners = "1,2,3,4,5,6";
    }

    public List<Integer> createLottoNumber() {
        return Arrays.asList(1,2,3,4,5,6);
    }

    private WinnerNumber createWinner(String input) {
        return new WinnerNumber(input);
    }

    @Test
    @DisplayName("당첨 번호 생성 확인")
    public void winnerNumberCountTest() throws Exception {
        //given
        List<Integer> input = createLottoNumber();

        //when
        WinnerNumber winnerNumber = new WinnerNumber(input);

        //then
        assertThat(winnerNumber.checkNumbers(input)).isTrue();
    }

    @Test
    @DisplayName("당첨 번호 중복 확인")
    public void winnerNumberDuplicateTest() throws Exception {
        //given
        String input = "1,1,2,3,4,5";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createWinner(input);
        });
    }

    @Test
    @DisplayName("당첨 번호 범위 예외 확인")
    public void winnerNumberSizeExceptionTest() throws Exception {
        //given
        String input = "1,2,3,4,5,46";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createWinner(input);
        });
    }

    @Test
    @DisplayName("당첨 번호 중복 예외 확인")
    public void winnerNumberDuplicateExceptionTest() throws Exception {
        //given
        String input = "1,1,1,1,1,1";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createWinner(input);
        });

    }
}
