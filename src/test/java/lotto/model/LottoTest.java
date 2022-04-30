package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.exception.LottoNumberDuplicateException;
import lotto.strategy.DuplicateNumberGenerateStrategy;
import lotto.strategy.FixedNumberGenerateStrategy;
import lotto.strategy.RandomNumberGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

  @Test
  @DisplayName("생성된 로또번호들의 갯수는 6개이다")
  void checkNumberOfGeneratedLottoNumbers() {
    // given
    Lotto lotto =  Lotto.create(new RandomNumberGenerateStrategy());

    // then
    assertThat(lotto.getLottoNumbers()).hasSize(6);
  }
  
  @Test
  @DisplayName("중복된 로또 번호가 존재한다면 예외처리를 한다")
  void exceptionDuplicateLottoNumbers() {
    // when & then
    assertThatThrownBy(() -> Lotto.create(new DuplicateNumberGenerateStrategy()))
        .isInstanceOf(LottoNumberDuplicateException.class);
  }

  @Test
  @DisplayName("구매한 로또번호와 지난 우승 로또번호와 일치하는 갯수")
  void checkNumberMatchingLottoNumbers() {
    // given
    Lotto lotto = Lotto.create(new FixedNumberGenerateStrategy());
    WinningLotto winningLotto1 = WinningLotto.create("1, 2, 3, 4, 5, 6");
    WinningLotto winningLotto2 = WinningLotto.create("1, 2, 3, 4, 10, 6");

    // when
    int matchResult1 = lotto.matchWinningLottoNumbers(winningLotto1);
    int matchResult2 = lotto.matchWinningLottoNumbers(winningLotto2);

    // then
    assertAll(
        () -> assertThat(matchResult1).isEqualTo(6),
        () -> assertThat(matchResult2).isEqualTo(5)
    );
  }
}
