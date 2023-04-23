package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
  private LottoTicket lottoTicket;

  @BeforeEach
  void beforeEach() {
    lottoTicket = new LottoTicket(Arrays.asList(4, 9, 29, 19, 6, 7));
  }

  @Test
  void 로또_티켓하나는_6개의_번호가_부여된다() {
    assertThat(lottoTicket.getNumbers()).hasSize(6);
  }

  @Test
  void 로또_번호가_6개가_아니면_IllegalArgumentException이_발생한다() {
    assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 6개여야 합니다.");
  }

  @Test
  void 로또_티켓의_숫자는_오름차순으로_정렬된다() {
    for (int i = 0; i < lottoTicket.getNumbers().size() - 1; i++) {
      assertThat(lottoTicket.getNumbers().get(i))
          .isLessThan(lottoTicket.getNumbers().get(i + 1));
    }
  }

  @Test
  void 로또_티켓에_겹치는_숫자가_있으면_안된다() {
    Set<Integer> set = new HashSet<>(lottoTicket.getNumbers());
    assertThat(set).hasSize(6);
  }
}