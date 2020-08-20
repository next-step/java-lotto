package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

  @Test
  void createSortedNormal() {
    assertThat(new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1)))
        .isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
  }

  @Test
  void unmodifiableList() {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);
    numbers.add(6);

    Lotto lotto = new Lotto(numbers);
    assertThatThrownBy(() -> lotto.getNumbers().add(7))
        .isInstanceOf(UnsupportedOperationException.class);
  }

}
