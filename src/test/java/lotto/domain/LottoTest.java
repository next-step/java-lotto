package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    //when
    Lotto lotto = new Lotto(numbers);

    //then
    assertThat(lotto.getLottoNumbers()).isEqualTo(numbers);
  }

  @Test
  @DisplayName("잘못된 생성 테스트")
  void invalidCreateTest() {
    //given
    List<Integer> nullNumbers = null;
    List<Integer> emptyNumbers = Collections.emptyList();
    List<Integer> smallNumbers = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> largeNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    List<Integer> duplicatedNumbers = Arrays.asList(1, 1, 2, 3, 4, 5);

    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Lotto(nullNumbers);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Lotto(emptyNumbers);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Lotto(smallNumbers);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Lotto(largeNumbers);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Lotto(duplicatedNumbers);
    });
  }
}
