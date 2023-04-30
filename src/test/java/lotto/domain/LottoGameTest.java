package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoGameTest {

  private LottoResult lottoResult;

  @BeforeEach
  public void setUp() {
    LottoTickets lottoTickets = new LottoTickets();

    lottoTickets.addLottoTicket(new LottoTicket(Set.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));
    lottoTickets.addLottoTicket(new LottoTicket(Set.of(LottoNumber.of(14), LottoNumber.of(15), LottoNumber.of(16), LottoNumber.of(17), LottoNumber.of(18), LottoNumber.of(19))));

    LottoTicket winningLottoTicket = new LottoTicket(Set.of(LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6), LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9)));
    LottoNumber bonusNumber = LottoNumber.of(23);

    LottoGame lottoGame = new LottoGame(lottoTickets, winningLottoTicket, bonusNumber);
    lottoResult = lottoGame.play();
  }

  @Test
  @DisplayName("수익률 테스트")
  public void 수익률() {
    assertThat(lottoResult.lottoRateOfReturn()).isEqualTo(2.5);
  }

  @Test
  @DisplayName("로또순위 당 개수 테스트")
  public void 로또순쉬_당_개수() {
    assertAll(
            () -> assertThat(lottoResult.numbersPerRank().get(LottoRank.FIFTH)).isEqualTo(1),
            () -> assertThat(lottoResult.numbersPerRank().get(LottoRank.FOURTH)).isEqualTo(0)
    );
  }
}
