package nextstep.lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

  @DisplayName("6개의 서로 다른 숫자가 아니면 로또는 생성할 수 없ㅅ다.")
  @Test
  public void spec01() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Set.of()));
    assertThatIllegalArgumentException().isThrownBy(
      () -> new Lotto(Set.of(LottoNumber.lottoNumber(1), LottoNumber.lottoNumber(2))));
  }

  @DisplayName("6개의 서로 다른 숫자로 로또를 생성할 수 있다.")
  @Test
  public void spec02() {
    assertThatNoException().isThrownBy(() ->
      new Lotto(1, 2, 3, 4, 5, 6)
    );
  }
}
