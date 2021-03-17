package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinnerNumberTest {

    @Test
    @DisplayName("당첨 번호 범위 확인")
    public void winnerNumberSizeTest() throws Exception {
        //given
        //when
        boolean result = WinnerNumber.isLottoNumberSize(1);

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("당첨 번호 범위미달 확인")
    public void winnerNumberExceptionTest() throws Exception {
        //given
        //when
        boolean result = WinnerNumber.isLottoNumberSize(0);

        //then
        assertThat(result).isTrue();
    }


    @Test
    @DisplayName("당첨 번호 범위초과 확인")
    public void winnerNumberSizeUpTest() throws Exception {
        //given
        //when
        boolean result = WinnerNumber.isLottoNumberSize(46);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("당첨 번호 중복 통과 확인")
    public void winnerNumberCountTest() throws Exception {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        //when
        boolean result = WinnerNumber.isDuplicateNumbers(numbers);

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("당첨 번호 중복 확인")
    public void winnerNumberDuplicateTest() throws Exception {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        //when
        boolean result = WinnerNumber.isDuplicateNumbers(numbers);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("당첨 번호 범위 예외 확인")
    public void winnerNumberSizeExceptionTest() throws Exception {
        //given
        String input = "1,2,3,4,5,46";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinnerNumber(input);
        });
    }

    @Test
    @DisplayName("당첨 번호 중복 예외 확인")
    public void winnerNumberDuplicateExceptionTest() throws Exception {
        //given
        String input = "1,1,1,1,1,1";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinnerNumber(input);
        });

    }
}
