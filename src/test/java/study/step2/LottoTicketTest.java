package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.domain.LottoTicket;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("지난주 당첨 번호에 따라 내가 산 로또에서 번호가 몇개나 맞았는지 구하는 메소드 테스트")
    public void countWinningNumbersTest(){
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> selectedMyLottoNumbers = Arrays.asList(1,3,5,7,9,11);
        assertThat(new LottoTicket(new MockLottoNumberGenerator(selectedMyLottoNumbers))
                .countWinningNumbers(winningNumbers)).isEqualTo(3);
    }
}
