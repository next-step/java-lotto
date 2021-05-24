package study.step2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

  @DisplayName("구매 금액을 입력 후 복권의 수 만큼  lottos 객체를 셍성하는지 테스트")
  @Test
  void makeLottosWithLottoCount() {
    // given
    int lottoCount = 3;

    // when
    Lottos lottos = Lottos.makeLottos(lottoCount);

    // then
    assertThat(lottos).isEqualTo(new Lottos(lottos.getLottos()));
  }

  @DisplayName("구매 금액을 0으로 입력했을 때, lotto 객체 크기가 0인지 테스트")
  @Test
  void makeLottosFail() {
    // given
    int lottoCount = 0;

    // when
    Lottos lottos = Lottos.makeLottos(lottoCount);

    // then
    assertThat(lottos).isEqualTo(new Lottos(new ArrayList<>()));
  }

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

  @DisplayName("로또 번호가 없을때, 빈 lottos객체가 생성되는지 테스트")
  @Test
  void createLottosWithEmptyLottoList() {
    //given
    List<Lotto> lottoList = new ArrayList<>();

    // when
    Lottos lottos = new Lottos(lottoList);

    // then
    assertThat(lottos.getLottos()).isEqualTo(lottoList);
  }

  @DisplayName("로또 번호와 보너스 번호를 넣었을 때, 1등 테스트")
  @Test
  void winingMatchTest() {
    //given
    int bonusNumber = 19;

    Lottos lottos = new Lottos(Arrays.asList(new Lotto("1, 2, 3, 12, 15, 16"), new Lotto("13, 17, 21, 28, 33, 44")));
    WinningLotto winingLotto = new WinningLotto("1, 2, 3, 12, 15, 16", bonusNumber);

    // when
    LottoResult LottoResult = lottos.match(winingLotto);
    Map<Rank, Integer> rankMap = LottoResult.getRankMap();

    // then
    assertThat(rankMap.get(Rank.FIRST)).isEqualTo(1);
  }

  @DisplayName("로또 번호와 보너스 번호를 넣었을 때, 2등 테스트")
  @Test
  void winingMatchTestWithBonusNumber() {
    //given
    int bonusNumber = 16;

    Lottos lottos = new Lottos(Arrays.asList(new Lotto("1, 2, 3, 12, 15, 16"), new Lotto("13, 17, 21, 28, 33, 44")));
    WinningLotto winingLotto = new WinningLotto("1, 2, 3, 12, 15, 44", bonusNumber);

    // when
    LottoResult LottoResult = lottos.match(winingLotto);
    Map<Rank, Integer> rankMap = LottoResult.getRankMap();

    // then
    assertThat(rankMap.get(Rank.SECOND)).isEqualTo(1);
  }

}
