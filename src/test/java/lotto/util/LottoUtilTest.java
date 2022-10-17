package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoUtilTest {

    @Test
    @DisplayName("지불한 금액만큼 로또 티켓 개수 반환")
    void getNumOfTicketsSuccess() {
        assertThat(LottoUtil.getNumOfTickets(3000))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("금액 부족으로 로또 티켓 개수 반환 실패")
    void getNumOfTicketsFailByPriceLowerThan1000() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoUtil.getNumOfTickets(900));
    }

    @Test
    @DisplayName("기입한 실 로또 번호를 숫자 리스트로 반환")
    void splitStringToNumbersSuccess() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numbers.add(i);
        }

        assertThat(LottoUtil.splitStringToNumbers(winningNumbers))
                .isEqualTo(numbers);
    }

}
