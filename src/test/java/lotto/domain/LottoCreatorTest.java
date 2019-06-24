package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCreatorTest {

  @DisplayName("로또 생성 테스트")
  @Test
  void create() {
    assertThat(LottoCreator.create()).isInstanceOf(LottoTicket.class);
  }
}
