package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  @DisplayName("로또 티켓에는 6개의 로또 번호가 존재한다")
  void lottoTicketHas6LottoNumbers() {
    LottoTicket lottoTicket = new LottoTicket();

    int lottoNumbersSize = lottoTicket.getLottoNumbers().size();

    assertEquals(6, lottoNumbersSize);
  }

  @Test
  @DisplayName("로또 티켓에는 중복되지 않는 로또 번호가 존재한다")
  void lottoTicketHasUniqueLottoNumbers() {
    LottoTicket lottoTicket = new LottoTicket();

    boolean isUnique = lottoTicket.getLottoNumbers().stream().distinct().count() == 6;

    assertTrue(isUnique);
  }

  @Test
  @DisplayName("로또 티켓은 오름차순 정렬된 로또 번호를 가지고 있다")
  void lottoTicketHasSortedLottoNumbers() {
    LottoTicket lottoTicket = new LottoTicket();

    // 오름차순 여부 확인
    boolean isSorted = IntStream.range(0, lottoTicket.getLottoNumbers().size() - 1)
        .allMatch(i -> lottoTicket.getLottoNumbers().get(i)
            .compareTo(lottoTicket.getLottoNumbers().get(i + 1)) <= 0);

    assertTrue(isSorted, "로또 티켓 번호가 오름차순으로 정렬되지 않았습니다.");
  }

}