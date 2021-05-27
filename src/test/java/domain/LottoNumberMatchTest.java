package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumberMatchTest {
   @Test
   public void 번호일치테스트_6자리_전부_일치_GREEN() {
     Integer[] winNumber = new Integer[]{1, 2, 3, 4, 5, 6};
     Integer[] lottoNumber = new Integer[]{1, 2, 3, 4, 5, 6};

     final Lotto lotto = new Lotto(lottoNumber);

     final Integer allMached = LottoNumberMatch.matchCount(winNumber, lotto);

       assertThat(allMached).isEqualTo(6);
       assertThat(lotto.matchCount()).isEqualTo(6);
   }

    @Test
    public void 번호일치테스트_RED() {
      Integer[] winNumber = new Integer[]{1, 2, 3, 4, 5, 6};
      Integer[] lottoNumber = new Integer[]{7, 8, 9, 10, 11, 12};

      final Lotto lotto = new Lotto(lottoNumber);

      final Integer nothingMatched = LottoNumberMatch.matchCount(winNumber, lotto);

      assertThat(nothingMatched).isEqualTo(0);
    }
}