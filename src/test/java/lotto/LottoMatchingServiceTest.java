package lotto;

import lotto.domain.BonusBall;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;
import lotto.domain.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoMatchingServiceTest {

    @DisplayName("수동 로또와 자동 로또를 입력하면 통계를 반환한다")
    @Test
    void auto_and_manual_lotto() {
        //지난 주 당첨 번호
        WinningNumbers winningNumbers = WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        //보너스볼
        BonusBall bonusBall = new BonusBall(7);

        //수동 로또
        LottoTicket lottoTicket1 = new LottoTicket(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket2 = new LottoTicket(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoTicket> manualLottos = Arrays.asList(lottoTicket1, lottoTicket2);

        //자동 로또
        LottoTicket lottoTicket3 = new LottoTicket(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket4 = new LottoTicket(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoTicket> autoLottos = Arrays.asList(lottoTicket3, lottoTicket4);



    }

    @DisplayName("당첨번호 5개, 보너스 볼 1개와 로또 번호가 일치했을 때 상금리스트에서 2등만 카운트되서 반환한다")
    @Test
    void second_prize_match() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        BonusBall bonusBall = new BonusBall(7);

        // 0~2개 일치는 상금이 없음
        LottoTicket lottoTicket1 = new LottoTicket(() -> Arrays.asList(10, 15, 20, 25, 30, 35)); // 0개 일치
        LottoTicket lottoTicket2 = new LottoTicket(() -> Arrays.asList(1, 15, 20, 25, 30, 35)); // 1개 일치
        LottoTicket lottoTicket3 = new LottoTicket(() -> Arrays.asList(1, 2, 20, 25, 30, 35)); // 2개 일치

        LottoTicket lottoTicket4 = new LottoTicket(() -> Arrays.asList(1, 2, 3, 25, 30, 35)); // 3개 일치
        LottoTicket lottoTicket5 = new LottoTicket(() -> Arrays.asList(1, 2, 3, 4, 30, 35)); // 4개 일치
        LottoTicket lottoTicket6 = new LottoTicket(() -> Arrays.asList(1, 2, 3, 4, 5, 35)); // 5개 일치
        LottoTicket lottoTicket7 = new LottoTicket(() -> Arrays.asList(1, 2, 3, 4, 5, 7)); // 5개 일치 + 보너스 볼일치
        LottoTicket lottoTicket8 = new LottoTicket(() -> Arrays.asList(1, 2, 3, 4, 5, 6)); // 6개 일치

        LottoMatchingService lottoMatchingService = new LottoMatchingService(winningNumbers, bonusBall);
        List<LottoTicket> lottoTickets = Arrays.asList(lottoTicket1, lottoTicket2, lottoTicket3, lottoTicket4, lottoTicket5, lottoTicket6, lottoTicket7, lottoTicket8);
        Map<Prize, Integer> numberOfWins = lottoMatchingService.matchWinningNumber(lottoTickets);
        System.out.println("numberOfWins = " + numberOfWins);

        Assertions.assertThat(numberOfWins.get(Prize.FIRST_PRIZE)).isEqualTo(1);
        Assertions.assertThat(numberOfWins.get(Prize.SECOND_PRIZE)).isEqualTo(1);
        Assertions.assertThat(numberOfWins.get(Prize.THIRD_PRIZE)).isEqualTo(1);
        Assertions.assertThat(numberOfWins.get(Prize.FOURTH_PRIZE)).isEqualTo(1);
        Assertions.assertThat(numberOfWins.get(Prize.FIFTH_PRIZE)).isEqualTo(1);
    }

    @DisplayName("당첨번호와 보너스 볼을 입력하면 일치하는 갯수를 담은 리스트 (3개,4개,5개,5개,6개)를 반환한다")
    @Test
    void size_match_winning_number_and_bonus_ball() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        BonusBall bonusBall = new BonusBall(7);

        LottoTicket lottoTicket4 = new LottoTicket(() -> Arrays.asList(1, 2, 3, 25, 30, 35)); // 3개 일치
        LottoTicket lottoTicket5 = new LottoTicket(() -> Arrays.asList(1, 2, 3,  4, 30, 35)); // 4개 일치
        LottoTicket lottoTicket6 = new LottoTicket(() -> Arrays.asList(1, 2, 3,  4,  5, 35)); // 5개 일치
        LottoTicket lottoTicket7 = new LottoTicket(() -> Arrays.asList(1, 2, 3,  4,  5,  7)); // 5개 일치 + 보너스 볼일치
        LottoTicket lottoTicket8 = new LottoTicket(() -> Arrays.asList(1, 2, 3,  4,  5,  6)); // 6개 일치

        LottoMatchingService lottoMatchingService = new LottoMatchingService(winningNumbers, bonusBall);
        List<LottoTicket> lottoTickets = Arrays.asList(lottoTicket4, lottoTicket5, lottoTicket6, lottoTicket7, lottoTicket8);

        Map<Prize, Integer> numberOfWins = lottoMatchingService.matchWinningNumber(lottoTickets);

        Assertions.assertThat(numberOfWins.size()).isEqualTo(5);
    }

}
