package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LottoGameTest {

  private LottoResult lottoResult;

  @BeforeEach
  public void setUp() {
    LottoTickets lottoTickets = new LottoTickets(
            List.of(
                    new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                    new LottoTicket(List.of(new LottoNumber(14), new LottoNumber(15), new LottoNumber(16), new LottoNumber(17), new LottoNumber(18), new LottoNumber(19)))
            )
    );
    LottoTicket winningLottoTicket = new LottoTicket(List.of(new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)));
    LottoNumber bonusNumber = new LottoNumber(23);

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
