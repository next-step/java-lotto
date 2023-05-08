package lotto;

import lotto.domain.raffle.BaseKoreaLottoRaffleGenerator;
import lotto.domain.raffle.LottoRaffleGenerator;
import lotto.domain.round.LottoRoundNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRaffleGeneratorTest {

  @Test
  @DisplayName("BaseKoreaLottoRaffleGenerator | 로또 6/45는 6개의 숫자를 추첨한다.")
  void 숫자추첨_6개_테스트() {

    // given
    LottoRaffleGenerator raffleGenerator = new BaseKoreaLottoRaffleGenerator();

    // when
    LottoRoundNumbers numbers = raffleGenerator.generateRaffleNumber();

    // then
    Assertions.assertThat(numbers)
        .extracting("numbers")
        .asList()
        .hasSize(6);
  }
}
