package study.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

  @DisplayName("countOfMatch에 해당하는 Rank Enum을 반환한다.")
  @Test
  public void valueOf(){
    assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
    assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS);
    assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS);
    assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
    assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
    assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
  }
}
