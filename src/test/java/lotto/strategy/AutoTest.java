package lotto.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동 발급")
public class AutoTest {

    public List<Integer> createLottoNumber() {
        return Arrays.asList(1,2,3,4,5,6);
    }

    @Test
    @DisplayName("번호 사이즈 6개 확인")
    public void autoNumberSizeSixTest() throws Exception {
        //given
        Numbers numbers = new Auto();

        //when

        //then
        assertThat(numbers.readOnlyNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("자동 번호 일치 확인")
    public void autoNumberTrueTest() throws Exception {
        //given
        List<Integer> intList = createLottoNumber();
        Numbers numbers = new Auto(intList);

        //when

        //then
        assertThat(numbers.checkNumbers(intList)).isTrue();
    }

    @Test
    @DisplayName("자동 번호 불일치 확인")
    public void autoNumberFalseTest() throws Exception {
        //given
        List<Integer> intList = createLottoNumber();
        Numbers numbers = new Auto();

        //when

        //then
        assertThat(numbers.checkNumbers(intList)).isFalse();
    }
}
