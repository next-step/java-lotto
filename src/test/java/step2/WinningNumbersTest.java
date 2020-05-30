package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("당첨 번호 클래스 테스트")
class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호 추가 중복 숫자 테스트")
    void addNumberDuplicatedNumberTest() {
        WinningNumbers winningNumbers = new WinningNumbers();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatIllegalArgumentException().isThrownBy(() ->
                list.forEach(winningNumbers::addNumber));
    }

    @Test
    @DisplayName("당첨 번호 추가 갯수 초과 테스트")
    void addNumberOverCountTest() {
        WinningNumbers winningNumbers = new WinningNumbers();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.forEach(winningNumbers::addNumber);
        assertThatIllegalArgumentException().isThrownBy(() ->
                winningNumbers.addNumber(3));
    }

    @Test
    @DisplayName("당첨 번호 갯수 확인 테스트")
    void countingWinningNumbersTest() {
        WinningNumbers winningNumbers = new WinningNumbers();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.forEach(winningNumbers::addNumber);
        List<Integer> lottoNumberList = new ArrayList<>(list);
        int i = winningNumbers.countingWinningNumbers(lottoNumberList);
        assertThat(i).isEqualTo(6);
    }
}