package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

  @Test
  @DisplayName("인스턴스가 기존에 존재한다면, 기존에 사용하고 있는 인스턴스를 사용")
  void equals() {
    LottoFactory instance = LottoFactory.getInstance();
    assertThat(instance).isEqualTo(LottoFactory.getInstance());
  }
}