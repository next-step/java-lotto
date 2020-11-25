package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ScannerTest {

    @Test
    @DisplayName("당첨번호와 로또를 비교해서 일치하는 숫자를 로또에 저장한다")
    public void scan_lotto_ticket() {
        Scanner scanner = new Scanner(Arrays.asList(1, 3, 23, 33, 35, 46));
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 3, 5, 6, 7, 8));
        scanner.scan(lottoTicket);
        assertThat(lottoTicket.getMatchingScore()).isEqualTo(2);
    }
}
