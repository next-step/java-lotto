package nextstep.lotto;

import static nextstep.lotto.LottoFactory.createLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Set;
import nextstep.lotto.domain.Lotto;
import nextstep.lotto.domain.LottoNumber;
import org.junit.jupiter.api.Assertions;
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
      createLotto(1, 2, 3, 4, 5, 6)
    );
  }

  @DisplayName("로또 숫자가 몇개나 일치하는지 알 수 있다.")
  @Test
  public void spec03() {
    final Lotto base = createLotto(1, 2, 3, 4, 5, 6);
    final Lotto match3 = createLotto(1, 2, 3, 10, 15, 25);
    final Lotto match4 = createLotto(1, 2, 3, 4, 15, 25);
    final Lotto match5 = createLotto(1, 2, 3, 4, 5, 25);
    final Lotto match6 = createLotto(1, 2, 3, 4, 5, 6);
    final Lotto matchNothing = createLotto(40, 41, 42, 43, 44, 45);
    Assertions.assertAll(
      () -> assertThat(base.match(match3)).isEqualTo(3),
      () -> assertThat(base.match(match4)).isEqualTo(4),
      () -> assertThat(base.match(match5)).isEqualTo(5),
      () -> assertThat(base.match(match6)).isEqualTo(6),
      () -> assertThat(base.match(matchNothing)).isEqualTo(0)
    );
  }

  @DisplayName("문자열로 로또를 생성할 수 있다.")
  @Test
  public void spec04() {
    assertThat(new Lotto("1, 2, 3, 4, 5, 6"))
      .isEqualTo(createLotto(1, 2, 3, 4, 5, 6));
  }
}
