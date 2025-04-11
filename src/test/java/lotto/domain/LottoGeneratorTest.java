package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

  @Test
  void 자동_로또_번호_생성() {
    assertThat(new LottoGenerator().generateAutoLotto().getNumbers()).hasSize(6);
  }
} 