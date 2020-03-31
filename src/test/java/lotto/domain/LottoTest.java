package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.FAILURE;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

  @DisplayName("Test to calculate the rank properly")
  @Test
  public void getRanksTest() {
    LottoGame firstPlace = new LottoGame(Arrays.asList(1,2,3,4,5,6));
    LottoGame secondPlace = new LottoGame(Arrays.asList(1,2,3,4,5,7));
    LottoGame thirdPlace = new LottoGame(Arrays.asList(1,2,3,4,5,8));
    LottoGame fourthPlace = new LottoGame(Arrays.asList(1,2,3,4,7,8));
    LottoGame fifthPlace = new LottoGame(Arrays.asList(1,2,3,7,8,9));
    LottoGame failure = new LottoGame(Arrays.asList(1,2,7,8,9,10));
    List<LottoGame> lottoNumbers = Arrays.asList(
        firstPlace,
        secondPlace,
        thirdPlace,
        fourthPlace,
        fifthPlace,
        failure
    );
    Lotto lotto = new Lotto(lottoNumbers);
    WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1,2,3,4,5,6), 7);

    List<Rank> ranks = lotto.getRanks(winningNumbers);

    assertThat(ranks.get(0)).isEqualTo(FIRST);
    assertThat(ranks.get(1)).isEqualTo(SECOND);
    assertThat(ranks.get(2)).isEqualTo(THIRD);
    assertThat(ranks.get(3)).isEqualTo(FOURTH);
    assertThat(ranks.get(4)).isEqualTo(FIFTH);
    assertThat(ranks.get(5)).isEqualTo(FAILURE);
  }
}
