package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LastWeekWinLottoTest {

  @Test
  public void 로또와_몇개의_숫자가_일치하는지_리턴한다() {
    LastWeekWinLotto winLotto = new LastWeekWinLotto("1,2,3,4,5,6", 9);
    Lotto lotto = new Lotto("4,5,6,7,8,9");
    assertThat(winLotto.getMatchCount(lotto)).isEqualTo(3);
  }

  @Test
  public void RankList를_리턴한다() {
    LastWeekWinLotto winLotto = new LastWeekWinLotto("1,2,3,4,5,6", 9);
    Lotto lotto = new Lotto("1,2,3,4,5,9");
    assertThat(winLotto.getResult(lotto)).isEqualTo(Rank.SECOND);

    Lotto lotto1 = new Lotto("11,12,13,14,15,19");
    assertThat(winLotto.getResult(lotto1)).isEqualTo(Rank.MISS);
  }

  @Test
  public void 보너스번호가있는지확인한다() {
    LastWeekWinLotto winLotto = new LastWeekWinLotto("1,2,3,4,5,6", 9);
    Lotto lotto = new Lotto("4,5,6,7,8,9");
    assertThat(winLotto.hasBonusNumber(lotto)).isEqualTo(true);
  }

  @Test
  public void 지난주_당첨번호와_보너스볼이_일치하면_예외처리() {
    assertThatThrownBy(()->{
          new LastWeekWinLotto("1,2,3,4,5,6",1);
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("당첨 번호와 보너스볼 번호가 일치할 수 업습니다.");
  }

}