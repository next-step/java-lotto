package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
  
  @Test
  @DisplayName("6자리의 숫자가 들어오는지 체크")
  public void checkLottoLength() {
    Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5));
    assertThatThrownBy(() -> {
      lotto.check();
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("숫자의 min, max 체크 / 0 ~ 45")
  public void checkMinMax() {
    Lotto min = new Lotto(Arrays.asList(0, 1, 2, 3, 4, 45));
    Lotto max = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46));
    
    assertThatThrownBy(() -> {
      min.check();
    }).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> {
      max.check();
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("중복되는 숫자가 존재하는지 체크")
  public void checkSameNumber() {
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5));
    assertThatThrownBy(() -> {
      lotto.check();
    }).isInstanceOf(IllegalArgumentException.class);
  }

}
