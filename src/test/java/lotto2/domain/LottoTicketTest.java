package lotto2.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  public void 당첨번호가_있는_경우() {
    List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);

    LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
    int matchCount = lottoTicket.findMatchingCount(winningNumbers);

    assertThat(matchCount).isEqualTo(3);
  }

  @Test
  public void 당첨번호가_없는_경우() {
    List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    List<Integer> winningNumbers = Arrays.asList(7, 8, 9, 10, 11, 12);

    LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
    int matchCount = lottoTicket.findMatchingCount(winningNumbers);

    assertThat(matchCount).isEqualTo(0);
  }
}