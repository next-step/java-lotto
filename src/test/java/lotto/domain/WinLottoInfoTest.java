package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import lotto.service.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinLottoInfoTest {

  @DisplayName("당첨로또에 관련된 로또번호와 보너스번호 생성.")
  @Test
  void 당첨로또정보생성() {

    Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
    int bonus = 7;

    WinLottoInfo winLottoInfo = new WinLottoInfo(lotto,bonus);

    assertThat(winLottoInfo).isEqualTo(new WinLottoInfo(lotto,bonus));
  }

  @DisplayName("당첨로또번호와 보너스번호간에 번호 중복시 검증 테스트.")
  @Test
  void 당첨로또번호와보너스번호간의중복검사() {

    Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
    int bonus = 1;

    assertThatThrownBy(
        () -> new WinLottoInfo(lotto,bonus)
    )
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("Rank 각 등급에 맞는 match값을 리턴하는지 테스트.")
  @Test
  void 로또등급생성자별비교()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    WinLottoInfo winLottoInfo = new WinLottoInfo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 31)), 7);
    Method getMatchCountForRank = winLottoInfo.getClass()
        .getDeclaredMethod("getMatchCountForRank", Lotto.class);
    getMatchCountForRank.setAccessible(true);

    assertThat(getMatchCountForRank.invoke(winLottoInfo,
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 31)))).isEqualTo(Rank.FIRST);

    assertThat(getMatchCountForRank.invoke(winLottoInfo,
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)))).isEqualTo(Rank.SECOND);

    assertThat(getMatchCountForRank.invoke(winLottoInfo,
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 13)))).isEqualTo(Rank.THIRD);

    assertThat(getMatchCountForRank.invoke(winLottoInfo,
        new Lotto(Arrays.asList(1, 2, 3, 4, 12, 13)))).isEqualTo(Rank.FOURTH);

    assertThat(getMatchCountForRank.invoke(winLottoInfo,
        new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)))).isEqualTo(Rank.FIFTH);

    assertThat(getMatchCountForRank.invoke(winLottoInfo,
        new Lotto(Arrays.asList(21, 22, 23, 11, 12, 13)))).isEqualTo(Rank.MISS);
  }

}