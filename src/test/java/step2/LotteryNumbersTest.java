package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("추첨된 로또 번호 클래스 리스트")
class LotteryNumbersTest {

    @Test
    @DisplayName("로또 번호 입력 후 확인 테스트")
    void settingLottoNumberTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        LotteryNumbers lotteryNumbers = new LotteryNumbers();
        for (Integer number : list) {
            lotteryNumbers.addLottoNumber(number);
        }

        assertThat(list).isEqualTo(lotteryNumbers.getLottoNumberList());
    }
}