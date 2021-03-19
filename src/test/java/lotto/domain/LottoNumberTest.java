package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    private String inputWinners;

    @BeforeEach
    public void setUp() {
        inputWinners = "1,2,3,4,5,6";
    }

    public List<Integer> createLottoNumber() {
        return Arrays.asList(1,2,3,4,5,6);
    }

    private LottoNumber createWinner(String input) {
        return new LottoNumber(input);
    }

    @Test
    @DisplayName("당첨 번호 생성 확인")
    public void winnerNumberCountTest() throws Exception {
        //given
        List<Integer> input = createLottoNumber();

        //when
        LottoNumber lottoNumber = new LottoNumber(input);

        //then
        assertThat(lottoNumber.checkNumbers(input)).isTrue();
    }

    @Test
    @DisplayName("당첨 번호 중복 확인")
    public void winnerNumberDuplicateTest2() throws Exception {
        //given
        String input = "1, 2, 3, 4, 5, 6";

        //when
        LottoNumber lottoNumber = createWinner(input);

        //then
        System.out.println("lottoNumber = " + lottoNumber.readOnlyWinnerNumbers().size());
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
