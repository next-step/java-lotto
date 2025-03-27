package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrize;
import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoRewardTest {

  private Lotto winningLotto;
  private Lottos lottos;
  private LottoNumber bonusNumber;

  @BeforeEach
  void setUp() {
    winningLotto = new Lotto(List.of(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
    ));

    lottos = new Lottos(List.of(
            new Lotto(List.of(
                    new LottoNumber(1), new LottoNumber(3), new LottoNumber(5),
                    new LottoNumber(7), new LottoNumber(9), new LottoNumber(11))),
            new Lotto(List.of(
                    new LottoNumber(1), new LottoNumber(2), new LottoNumber(5),
                    new LottoNumber(6), new LottoNumber(12), new LottoNumber(14))),
            new Lotto(List.of(
                    new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                    new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))
    ));
    bonusNumber = new LottoNumber(7);
  }

  @DisplayName("prizeMap 생성 테스트")
  @Test
  void createPrizeMap() {
    LottoReward lottoReward = new LottoReward(lottos, winningLotto, bonusNumber);

    assertThat(lottoReward.getPrizeCount(LottoPrize.THREE_MATCHES)).isEqualTo(1);
    assertThat(lottoReward.getPrizeCount(LottoPrize.FOUR_MATCHES)).isEqualTo(1);
    assertThat(lottoReward.getPrizeCount(LottoPrize.FIVE_MATCHES)).isEqualTo(0);
    assertThat(lottoReward.getPrizeCount(LottoPrize.SIX_MATCHES)).isEqualTo(1);
  }

  @DisplayName("총 당첨금 계산 테스트")
  @Test
  void calculateTotalWinningMoney() {
    LottoReward lottoReward = new LottoReward(lottos, winningLotto, bonusNumber);

    assertThat(lottoReward.calculateTotalWinningMoney()).isEqualTo(2000055000);
  }
}
