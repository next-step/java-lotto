package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

  @Test
  @DisplayName("로또 갯수 만큼 자동 로또 생성")
  void givenLottoCount_ShouldBeAutoLotto() {
    assertThat(LottoFactory.lotto(3)).hasSize(3);
  }

  @Test
  @DisplayName("수동 로또 한개 생성")
  void generateManualLotto() {
    assertThat(LottoFactory.lotto("1,2,3,4,5,6")).isEqualTo(LottoFactory.lotto("1,2,3,4,5,6"));
  }

  @Test
  @DisplayName("수동 로또 여러개 생성")
  void generateMultiplyManualLotto() {
    List<Lotto> lottos = LottoFactory.lotto(
        List.of("1,2,3,4,5,6", "7,8,9,10,11,12", "13,14,15,16,17,18"));
    assertThat(lottos).contains(
        LottoFactory.lotto("1,2,3,4,5,6"),
        LottoFactory.lotto("7,8,9,10,11,12"),
        LottoFactory.lotto("13,14,15,16,17,18")
    );
  }

  @Test
  @DisplayName("자동과 수동 로또 여러개 함께 생성")
  void generateLottoWithManualLotto() {
    List<Lotto> lottos = LottoFactory.lotto(3,
        List.of("1,2,3,4,5,6", "7,8,9,10,11,12", "13,14,15,16,17,18"));
    assertThat(lottos).hasSize(6);
    assertThat(lottos).contains(
        LottoFactory.lotto("1,2,3,4,5,6"),
        LottoFactory.lotto("7,8,9,10,11,12"),
        LottoFactory.lotto("13,14,15,16,17,18")
    );
  }
}
