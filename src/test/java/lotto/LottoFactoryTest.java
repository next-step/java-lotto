package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

  @Test
  @DisplayName("로또 번호 생성")
  void create() {
    assertThat(LottoFactory.createAuto().getLottoNumbers()).hasSize(6);
  }

  @Test
  @DisplayName("문자열로 로또 번호 생성")
  void givenNumber_shouldCreate() {
    assertThat(LottoFactory.createManual("1,2,3,4,5,6").getLottoNumbers()).hasSize(6);
  }

}
