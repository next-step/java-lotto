package lotto.domain.model;

import static lotto.domain.model.Trilean.FALSE;
import static lotto.domain.model.Trilean.IRRELEVANCE;
import static lotto.domain.model.Trilean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrileanTest {

  @DisplayName("Test for matches operator of Trilean with boolean")
  @Test
  public void matchesTest() {
    assertThat(TRUE.matches(true)).isTrue();
    assertThat(TRUE.matches(false)).isFalse();

    assertThat(FALSE.matches(true)).isFalse();
    assertThat(FALSE.matches(false)).isTrue();

    assertThat(IRRELEVANCE.matches(true)).isTrue();
    assertThat(IRRELEVANCE.matches(false)).isTrue();
  }
}
