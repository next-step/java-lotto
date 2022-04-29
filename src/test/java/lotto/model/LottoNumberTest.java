package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    
    @Test
    @DisplayName("로또 번호 한개를 객체로 생성한다")
    void createLottoNumberAsObject() {
      // given
      int value = 1;

      // when
      LottoNumber lottoNumber = new LottoNumber(value);
      
      // then
      assertThat(lottoNumber.getValue()).isEqualTo(value);
    }
    
    @ParameterizedTest
    @DisplayName("로또의 번호가 1 ~ 45 사이의 값이 아닌 {0}인 경우, 예외가 발생한다")
    @ValueSource(ints = {0, 46})
    void exceptionNotLottoNumberBetweenOneAndFortyFive(int value) {
      // when & then
      assertThatThrownBy(() -> new LottoNumber(value))
          .isInstanceOf(IllegalArgumentException.class);
    }
}
