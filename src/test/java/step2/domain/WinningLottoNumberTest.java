package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoNumberTest {

    @Test
    @DisplayName(value = "WinningLottoNumber 생성 테스트")
    void create() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,45);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(list);

        assertThat(winningLottoNumber.getNumbers().size()).isEqualTo(6);
        assertThat(winningLottoNumber.getNumbers()).containsAll(list);
    }

    @Test
    @DisplayName(value = "잘못된 숫자 리스트를 입력하면 IllegalArgumentException 발생")
    void numberValid_IllegalArgumentException() {
        List<Integer> numberGes = Arrays.asList(1,2,3,4,5,46);
        assertThatThrownBy(() -> new WinningLottoNumber(numberGes))
                .isInstanceOf(IllegalArgumentException.class);

        List<Integer> numberGreaterList = Arrays.asList(0,2,3,4,5,45);
        assertThatThrownBy(() -> new WinningLottoNumber(numberGreaterList))
                .isInstanceOf(IllegalArgumentException.class);

        List<Integer> countLessList = Arrays.asList(1,2,3,4,5);
        assertThatThrownBy(() -> new WinningLottoNumber(countLessList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
