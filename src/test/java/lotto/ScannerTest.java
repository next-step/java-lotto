package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScannerTest {

    @Test
    @DisplayName("로또티켓을 모두 스캔해서 수익률을 계산한다")
    public void scan_all_lotto_tickets() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 3, 23, 33, 35, 46));
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(lottoTicket);
        Scanner scanner = new Scanner(Arrays.asList(1, 3, 23, 33, 35, 46));
        LottoResult lottoResult = scanner.scanAll(lottoTickets);
        assertThat(lottoResult.getProfitRatio()).isEqualTo(2000000000/1000);
    }
}
