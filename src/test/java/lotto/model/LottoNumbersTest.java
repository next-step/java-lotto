package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoNumberDuplicateException;
import lotto.strategy.DuplicateNumberGenerateStrategy;
import lotto.strategy.RandomNumberGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

  @Test
  @DisplayName("생성된 로또번호들의 갯수는 6개이다")
  void checkNumberOfGeneratedLottoNumbers() {
    // given
    LottoNumbers lottoNumbers =  LottoNumbers.create(new RandomNumberGenerateStrategy());

    // then
    assertThat(lottoNumbers.getLottoNumbers()).hasSize(6);
  }
  
  @Test
  @DisplayName("중복된 로또 번호가 존재한다면 예외처리를 한다")
  void exceptionDuplicateLottoNumbers() {
    // when & then
    assertThatThrownBy(() -> LottoNumbers.create(new DuplicateNumberGenerateStrategy()))
        .isInstanceOf(LottoNumberDuplicateException.class);
  }
}
