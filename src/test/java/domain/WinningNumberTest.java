package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {

    @Test
    @DisplayName("로또랑 비교하여 당첨 결과를 구한다.")
    public void winningResult() {
        //given
        String winningNumbers = "1, 2, 3, 4, 5, 7";
        String lottoNumbers = "1, 3, 5, 7, 9, 11";
        LottoTicket lottoTicket = new LottoTicket(Arrays.stream(lottoNumbers.split(", "))
                .map(s -> new LottoNumber(Integer.parseInt(s)))
                .collect(Collectors.toList()));
        LottoMachine lottoMachine = new LottoMachine();
        WinningNumber winningNumber = InputView.winningNumber(winningNumbers);

        //when
        int winningCount = winningNumber.winningCount(lottoTicket);

        //then
        assertThat(winningCount).isEqualTo(4);
    }
}
