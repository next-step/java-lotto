package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

  private LottoTicket winningLottoTicket;

  @BeforeEach
  public void setUp() {
    winningLottoTicket = new LottoTicket(() -> List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(5),
            new LottoNumber(7),
            new LottoNumber(9),
            new LottoNumber(11)
    ));
  }

  @Test
  @DisplayName("로또 티켓 생성하여 당첨 번호와 매치되는 개수 반환 테스트")
  public void match_로또_번호() {
    LottoTicket lottoTicket = new LottoTicket(() -> List.of(
            new LottoNumber(1),
            new LottoNumber(3),
            new LottoNumber(5),
            new LottoNumber(7),
            new LottoNumber(13),
            new LottoNumber(11)
    ));

    assertThat(lottoTicket.matchLottoCount(winningLottoTicket))
            .isEqualTo(4);
  }

  @Test()
  @DisplayName("로또 번호 6개가 아닌 로또 티켓 생성하는 경우 IllegalArgumentException throw")
  public void create_개수가_맞지_않는_로또() {
    assertThatThrownBy(() -> new LottoTicket(() -> List.of(
            new LottoNumber(1),
            new LottoNumber(3),
            new LottoNumber(5),
            new LottoNumber(7),
            new LottoNumber(11)
    )))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 6개 입력하셔야 합니다.");
  }
}
