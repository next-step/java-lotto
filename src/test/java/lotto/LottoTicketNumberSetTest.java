package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketNumberSetTest {

  @Test
  @DisplayName("로또 티켓에서 사용하는 number set에는 6개의 로또 번호가 존재한다")
  void lottoTicketNumberSetHas6LottoNumbers() {
    LottoTicketNumberSet lottoTicketNumberSet = new LottoTicketNumberSet();

    int lottoNumbersSize = lottoTicketNumberSet.getNumbers().size();

    assertEquals(6, lottoNumbersSize);
  }

  @Test
  @DisplayName("number set은 중복되지 않는 로또 번호가 존재한다")
  void lottoTicketHasUniqueLottoNumbers() {
    LottoTicketNumberSet lottoTicketNumberSet = new LottoTicketNumberSet();

    boolean isUnique = lottoTicketNumberSet.getNumbers().stream().distinct().count() == 6;

    assertTrue(isUnique);
  }

  @Test
  @DisplayName("number set은 오름차순 정렬된 로또 번호를 가지고 있다")
  void lottoTicketHasSortedLottoNumbers() {
    LottoTicketNumberSet lottoTicketNumberSet = new LottoTicketNumberSet();

    // 오름차순 여부 확인
    boolean isSorted = IntStream.range(0, lottoTicketNumberSet.getNumbers().size() - 1)
        .allMatch(i -> lottoTicketNumberSet.getNumbers().get(i)
            .compareTo(lottoTicketNumberSet.getNumbers().get(i + 1)) <= 0);

    assertTrue(isSorted, "로또 티켓 번호가 오름차순으로 정렬되지 않았습니다.");
  }

  @Test
  @DisplayName("number set은 6개의 로또 번호로, 순서와 상관없이 값으로 객체를 비교한다")
  void lottoTicketNumberSetEqualsByValue() {
    LottoTicketNumberSet lottoTicketNumberSet1 = new LottoTicketNumberSet(
        IntStream.range(1, 7).mapToObj(LottoTicketNumber::new).collect(
            Collectors.toList()));
    LottoTicketNumberSet lottoTicketNumberSet2 = new LottoTicketNumberSet(
        IntStream.range(1, 7).mapToObj(LottoTicketNumber::new).sorted(Comparator.reverseOrder()).collect(
            Collectors.toList()));

    assertEquals(lottoTicketNumberSet1, lottoTicketNumberSet2);
  }
}