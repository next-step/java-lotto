package study.step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.domain.Lotto;
import study.step2.domain.Lottos;

public class LottosTest {

  @DisplayName("lottos 객체 생성 테스트")
  @Test
  void createLottos() {
    //given
    List<Lotto> lottoList = new ArrayList<>(Arrays.asList(new Lotto(), new Lotto()));

    // when
    Lottos lottos = new Lottos(lottoList);

    // then
    assertThat(lottos.getLottos()).isEqualTo(lottoList);
  }

  @DisplayName("로보 번호가 없을때, 빈 lottos객체가 생성되는지 테스트")
  @Test
  void createLottos1() {
    //given
    List<Lotto> lottoList = new ArrayList<>();

    // when
    Lottos lottos = new Lottos(lottoList);

    // then
    assertThat(lottos.getLottos()).isEqualTo(lottoList);
  }

}
