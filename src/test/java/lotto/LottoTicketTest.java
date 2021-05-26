package lotto;

import lotto.domain.*;
import lotto.exception.CustomIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @DisplayName("당첨번호와 티켓번호가 일치하지 않는 비교결과 테스트")
    @Test
    void check_match_result() {
        //Given
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 45);
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(11,12,13,14,17,18));

        //When
        Rank rank = lottoTicket.rankBasedOn(winningNumbers);

        //
        assertThat(rank).isEqualTo(Rank.ELSE);
    }

    @DisplayName("[,] 출력 포맷 점검")
    @Test
    void check_toString_print_result() {
        //Given
        Pattern pattern = Pattern.compile("\\[.*,*]");
        LottoTicket lottoTicket = LottoTicketGenerator.start().extract();

        //When
        String print = lottoTicket.toString();

        //Then
        assertThat(print).matches(pattern);
    }

    @DisplayName("로또티켓의 번호가 6개가 아니라면 Exception이 발생한다")
    @Test
    void throw_exception_when_numbers_not_six() {
        //Given + When + Then
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(11,12,13,14,17,18,20)))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

    @DisplayName("로또티켓의 번호가 6개인데, 중복이 발생하면 Exception이 발생한다")
    @Test
    void throw_exception_when_numbers_duplicated() {
        //Given + When + Then
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(11,12,13,14,17,17)))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

    @DisplayName("정확한 Rank를 내놓는지 확인 : 보너스 볼이 틀린 경우")
    @Test
    void return_right_status_after_matching_without_bonus() {
        //Given + When
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(11,12,13,14,15,17));
        Rank rank = lottoTicket.rankBasedOn(new WinningNumbers(Arrays.asList(11, 12, 13, 14, 15, 18), 45));

        //Then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("정확한 Rank를 내놓는지 확인 : 보너스 볼 있는 경우")
    @Test
    void return_right_status_after_matching_with_bonus() {
        //Given + When
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(11,12,13,14,15,17));
        Rank rank = lottoTicket.rankBasedOn(new WinningNumbers(Arrays.asList(11, 12, 13, 14, 15, 18), 17));

        //Then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
