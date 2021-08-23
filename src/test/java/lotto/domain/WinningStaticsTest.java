package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStaticsTest {

  @Test
  @DisplayName("통계값 일치 확인 테스트")
  void getResultByMatchedCntTest() {
    //given
    Lotto winningLotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});

    Lotto lotto1 = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
    Lotto lotto2 = new Lotto(new int[]{10, 2, 3, 4, 5, 6});
    Lotto lotto3 = new Lotto(new int[]{10, 20, 3, 40, 5, 6});
    Lotto lotto4 = new Lotto(new int[]{10, 20, 30, 4, 5, 6});
    Lotto lotto5 = new Lotto(new int[]{10, 20, 30, 40, 41, 42});
    List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);

    //when
    WinningStatics statics = new WinningStatics(lottos, winningLotto);

    //then
    assertThat(statics.getResultByMatchedCnt(6)).isEqualTo(1);
    assertThat(statics.getResultByMatchedCnt(5)).isEqualTo(1);
    assertThat(statics.getResultByMatchedCnt(4)).isEqualTo(0);
    assertThat(statics.getResultByMatchedCnt(3)).isEqualTo(2);
    assertThat(statics.getResultByMatchedCnt(0)).isEqualTo(1);
  }

  @Test
  @DisplayName("수익률 확인 테스트")
  void getRateOfReturn() {
    //given
    Lotto winningLotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});

    Lotto lotto1 = new Lotto(new int[]{8, 21, 23, 41, 42, 43});
    Lotto lotto2 = new Lotto(new int[]{3, 5, 11, 16, 32, 38});
    Lotto lotto3 = new Lotto(new int[]{7, 11, 16, 35, 36, 44});
    Lotto lotto4 = new Lotto(new int[]{1, 8, 11, 31, 41, 42});
    Lotto lotto5 = new Lotto(new int[]{13, 14, 16, 38, 42, 45});
    Lotto lotto6 = new Lotto(new int[]{7, 11, 30, 40, 42, 43});
    Lotto lotto7 = new Lotto(new int[]{2, 13, 22, 32, 38, 45});
    Lotto lotto8 = new Lotto(new int[]{23, 25, 33, 36, 39, 41});
    Lotto lotto9 = new Lotto(new int[]{1, 3, 5, 14, 22, 45});
    Lotto lotto10 = new Lotto(new int[]{5, 9, 38, 41, 43, 44});
    Lotto lotto11 = new Lotto(new int[]{2, 8, 9, 18, 19, 21});
    Lotto lotto12 = new Lotto(new int[]{13, 14, 18, 21, 23, 35});
    Lotto lotto13 = new Lotto(new int[]{17, 21, 29, 37, 42, 45});
    Lotto lotto14 = new Lotto(new int[]{3, 8, 27, 30, 35, 44});

    List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7,
        lotto8, lotto9, lotto10, lotto11, lotto12, lotto13, lotto14);

    //when
    WinningStatics winningStatics = new WinningStatics(lottos, winningLotto);

    //then
    double expected =
        (double) LottoPrize.FOURTH.getPrizeMoney() / (14 * LottoGame.LOTTO_PRICE.getValue());
    assertThat(winningStatics.getRateOfReturn()).isEqualTo(expected);
  }
}
