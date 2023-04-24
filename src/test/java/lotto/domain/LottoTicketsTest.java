package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTicketsTest {

  private LottoTicket winningLottoTicket;

  @BeforeEach
  public void setUp() {
    winningLottoTicket = new LottoTicket(List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)));
  }

  @Test
  @DisplayName("자동 횟수 입력하면 해당 사이즈만큼 로또티켓이 있는 LottoTickets 객체 반환 테스트")
  public void create_자동() {
    LottoTickets lottoTickets = new LottoTickets();

    lottoTickets.addLottoTicket(new RandomLottoStrategy().issue());
    lottoTickets.addLottoTicket(new RandomLottoStrategy().issue());

    assertThat(lottoTickets.unmodifiedLottoTickets().size())
            .isEqualTo(2);
  }

  @Test
  @DisplayName("구매한 티켓들에 대해 당첨 번호와 맞는 개수 리스트 반환 테스트")
  public void matchesLottoTickets_맞는_번호_개수() {
    LottoTickets lottoTickets = new LottoTickets();

    lottoTickets.addLottoTicket(new LottoTicket(List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6))));
    lottoTickets.addLottoTicket(new LottoTicket(List.of(
            new LottoNumber(1),
            new LottoNumber(9),
            new LottoNumber(3),
            new LottoNumber(34),
            new LottoNumber(5),
            new LottoNumber(6))));
    lottoTickets.addLottoTicket(new LottoTicket(List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(12),
            new LottoNumber(4),
            new LottoNumber(27),
            new LottoNumber(14))));

    assertAll(
            () -> assertThat(lottoTickets.matchesLottoTickets(winningLottoTicket).get(0)).isEqualTo(6),
            () -> assertThat(lottoTickets.matchesLottoTickets(winningLottoTicket).get(1)).isEqualTo(4),
            () -> assertThat(lottoTickets.matchesLottoTickets(winningLottoTicket).get(2)).isEqualTo(3)
    );
  }
}
