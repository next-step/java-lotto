package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("당첨번호와 티켓번호가 비교결과 테스트")
    @Test
    void check_match_result() {
        //Given
        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1,2,3,4,5,6});
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(11), new LottoNumber(12),
                                                  new LottoNumber(13), new LottoNumber(14),
                                                  new LottoNumber(17), new LottoNumber(18)
                                                );
        LottoTicket lottoTicket = new LottoTicket(numbers);

        //When
        MatchStatus matchStatus = lottoTicket.matchingStatusWith(winningNumbers);

        //
        assertThat(matchStatus).isEqualTo(MatchStatus.ELSE);
    }

    @DisplayName("[,] 출력 포맷 점검")
    @Test
    void check_toString_print_result(){
        //Given
        Pattern pattern = Pattern.compile("\\[.*,*]");

        //Pattern pattern = Pattern.compile("[0-9]");
        LottoTicket lottoTicket = LottoTicketGenerator.start().extract();

        //When
        String print = lottoTicket.toString();

        //Then
        assertThat(print).matches(pattern);
    }
}
