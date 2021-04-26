package study.step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.controller.LottoController;
import study.step2.domain.Lotto;
import study.step2.domain.LottoResult;
import study.step2.domain.Lottos;

public class LottoControllerTest {

  @DisplayName("구매 금액을 입력 후 복권의 수 만큼  lottos 객체를 셍성하는지 테스트")
  @Test
  void createLottos() {
    // given
    int money = 3000;
    int lottoCount = 3;
    LottoController lottoController = new LottoController();

    // when
    Lottos lottos = lottoController.createLottos(money);

    // then
    assertThat(lottos.getLottos().size()).isEqualTo(lottoCount);
  }

  @DisplayName("구매 금액을 0으로 입력했을 때, lottos 객체 크기가 0인지 테스트")
  @Test
  void createLottosFail() {
    // given
    int money = 0;
    int lottoCount = 0;
    LottoController lottoController = new LottoController();

    // when
    Lottos lottos = lottoController.createLottos(money);

    // then
    assertThat(lottos.getLottos().size()).isEqualTo(lottoCount);
  }

  @DisplayName("구매 금액, 로또 번호와 당첨 금액을 입력했을때, 당첨 결과가 null이 아닌지 테스트")
  @Test
  void findLottoWinning() {
    // given
    int money = 1000;
    Set<Integer> pickedLottoNumbers = new TreeSet<>(Arrays.asList(1, 2, 3, 12, 15, 16));

    Lotto lotto = new Lotto(pickedLottoNumbers);
    Lottos lottos = new Lottos(new ArrayList<>(Arrays.asList(new Lotto(pickedLottoNumbers))));

    LottoController lottoController = new LottoController();

    // when
    LottoResult lottoResult = lottoController.findLottoWinning(lottos, lotto, money);

    // then
    assertThat(lottoResult).isNotNull();
  }

}
