package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

  @ParameterizedTest(name = "생성 테스트 : {0}원")
  @ValueSource(longs = {0, 1, 2, 20_000_000_000L})
  void createTest(long value) {
    //when
    Money money = new Money(value);

    //then
    assertThat(money.value()).isEqualTo(value);
  }

  @ParameterizedTest(name = "잘못된 생성 테스트 : {0}원")
  @ValueSource(longs = {-1, -2, -20_000_000_000L})
  void invalidCreateTest(long value) {
    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Money(value);
    });
  }

  @Test
  @DisplayName("동등, 대소관계 테스트")
  void compareToTest() {
    //when
    Money money1 = new Money(10);
    Money money2 = new Money(20);
    Money money3 = new Money(20);

    //then
    assertThat(money1.compareTo(money2) < 0).isTrue();
    assertThat(money2.compareTo(money1) > 0).isTrue();
    assertThat(money2).isEqualTo(money3);
  }
}
