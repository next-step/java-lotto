package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningTicketTest {

  private LottoTicket lottoTicket;
  private WinningTicket winningTicket;

  @BeforeEach
  public void setUp() {
    lottoTicket = new LottoTicket(Set.of(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
    ));

    LottoTicket winningLottoTicket = new LottoTicket(Set.of(
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6),
            LottoNumber.of(7),
            LottoNumber.of(8)
    ));

    winningTicket = new WinningTicket(
            winningLottoTicket,
            LottoNumber.of(1)
    );
  }

  @Test
  @DisplayName("당첨 로또 번호와 비교해서 일치하는 개수 반환 테스트")
  public void 로또_번호_비교() {
    assertThat(winningTicket.matchLottoCount(lottoTicket)).isEqualTo(4);
  }

  @Test
  @DisplayName("보너스 번호를 가지고 있는지 확인 테스트")
  public void 보너스_로또_번호_확인() {
    assertTrue(winningTicket.containsBonusNumber(lottoTicket));
  }
}
