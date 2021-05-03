package study.step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.domain.Lotto;
import study.step2.domain.LottoNumber;
import study.step2.domain.LottoResult;
import study.step2.domain.Lottos;
import study.step2.domain.Rank;

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
    Lottos lottos = new Lottos(Arrays.asList(new Lotto("1, 2, 3, 12, 15, 16"), new Lotto("13, 17, 21, 28, 33, 44")));
    Lotto winingLotto = new Lotto("1, 2, 3, 12, 15, 16");
    LottoNumber bonusNumber = new LottoNumber(16);

    // when
    LottoResult LottoResult = lottos.match(winingLotto, bonusNumber);
    Map<Rank, Integer> rankMap = LottoResult.getRankMap();

    // then
    assertThat(rankMap.get(Rank.FIRST)).isEqualTo(1);
  }

  @DisplayName("로또 번호와 보너스 번호를 넣었을 때, 2등 테스트")
  @Test
  void winingMatchTestWithBonusNumber() {
    //given
    Lottos lottos = new Lottos(Arrays.asList(new Lotto("1, 2, 3, 12, 15, 16"), new Lotto("13, 17, 21, 28, 33, 44")));
    Lotto winingLotto = new Lotto("1, 2, 3, 12, 15, 44");
    LottoNumber bonusNumber = new LottoNumber(16);

    // when
    LottoResult LottoResult = lottos.match(winingLotto, bonusNumber);
    Map<Rank, Integer> rankMap = LottoResult.getRankMap();

    // then
    assertThat(rankMap.get(Rank.SECOND)).isEqualTo(1);
  }

}
