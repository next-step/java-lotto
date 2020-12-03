package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScannerTest {

    final static int PAYMENT = 1000;
    final static int BONUS_NUMBER = 7;
    final static List<Integer> WINNING_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);
    final static List<Integer> MATCHED_4 = Arrays.asList(1, 2, 3, 4, 45, 44);
    final static List<Integer> MATCHED_5_AND_BONUS = Arrays.asList(1, 2, 3, 4, 5, 7);

    private Scanner scanner;

    @BeforeEach
    public void setUp() {
        scanner = new Scanner(WINNING_NUMBERS, BONUS_NUMBER);
    }

    @Test
    @DisplayName("4개가 일치하는 경우")
    public void scan_all_lotto_tickets() {
        LottoTicket lottoTicket = new LottoTicket(MATCHED_4);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(lottoTicket);
        LottoResult lottoResult = scanner.scanAll(lottoTickets);
        assertThat(lottoResult.getProfitRatio()).isEqualTo(Rank.FOURTH.getProfit()/PAYMENT);
    }

    @Test
    @DisplayName("보너스 번호가 일치해서 2등이 되는 경우")
    public void scan_all_second() {

        LottoTicket lottoTicket = new LottoTicket(MATCHED_5_AND_BONUS);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(lottoTicket);
        LottoResult lottoResult = scanner.scanAll(lottoTickets);
        assertThat(lottoResult.getProfitRatio()).isEqualTo(Rank.SECOND.getProfit()/PAYMENT);
    }
}
