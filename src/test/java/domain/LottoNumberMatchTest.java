package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumberMatchTest {
   @Test
   public void 번호일치테스트_GREEN() {
       Integer[] winNumber = new Integer[]{1, 2, 3, 4, 5, 6};
       Integer[] lottoNumber = new Integer[]{1, 2, 3, 4, 5, 6};

       final Integer allMached = LottoNumberMatch.matchCount(winNumber, lottoNumber);

       assertThat(allMached).isEqualTo(6);
   }

    @Test
    public void 번호일치테스트_RED() {
        Integer[] winNumber = new Integer[]{1, 2, 3, 4, 5, 6};
        Integer[] lottoNumber = new Integer[]{7, 8, 9, 10, 11, 12};

        final Integer nothingMatched = LottoNumberMatch.matchCount(winNumber, lottoNumber);

        assertThat(nothingMatched).isEqualTo(0);
    }
}