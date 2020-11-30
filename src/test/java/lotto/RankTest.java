package lotto;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("enum Test")
    public void enumTest(){
      assertThat(Rank.rank(6,false)).isEqualByComparingTo(Rank.FIRST);
    }

}
