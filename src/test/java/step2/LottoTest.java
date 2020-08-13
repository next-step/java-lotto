package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  void validateLength() {
    assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void validateDuplicate() {
    assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 1)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void createNormal() {
    assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))
        .isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
  }

}
