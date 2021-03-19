package lotto.strategy;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("수동 입력")
public class ManualTest {
    private String inputWinners;

    @BeforeEach
    public void setUp() {
        inputWinners = "1,2,3,4,5,6";
    }

    public List<Integer> createLottoNumber() {
        return Arrays.asList(1,2,3,4,5,6);
    }

    private Numbers createWinner(String input) {
        return new Manual(input);
    }

    @Test
    @DisplayName("당첨 번호 6개 사이즈 확인")
    public void winnerNumberSizeSixTest() throws Exception {
        //given
        Numbers winnerNumber = new Manual(inputWinners);

        //when

        //then
        assertThat(winnerNumber.readOnlyNumbers().size()).isEqualTo(6);
    }


    @Test
    @DisplayName("로또 번호 중복 확인")
    public void winnerNumberDuplicateTest() throws Exception {
        //given
        String input = "1,1,2,3,4,5";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createWinner(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,45", "1,2,3,4,5,46"})
    @DisplayName("로또 번호 1 ~ 45 벗어날 시 예외 확인")
    public void winnerNumberSizeExceptionTest() throws Exception {
        //given
        String input = "1,2,3,4,5,46";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createWinner(input);
        });
    }

    @Test
    @DisplayName("로또 번호 중복 예외 확인")
    public void winnerNumberDuplicateExceptionTest() throws Exception {
        //given
        String input = "1,1,1,1,1,1";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createWinner(input);
        });
    }
}
