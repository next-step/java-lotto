package lotto.domain;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private List<LottoNumber> LOTTO_NUMS1 = Arrays.asList(new LottoNumber[]{LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)});
    private List<LottoNumber> LOTTO_NUMS2 = Arrays.asList(new LottoNumber[]{LottoNumber.of(10), LottoNumber.of(13), LottoNumber.of(16), LottoNumber.of(23), LottoNumber.of(45), LottoNumber.of(35)});
    private List<LottoNumber> LOTTO_NUMS3 = Arrays.asList(new LottoNumber[]{LottoNumber.of(1), LottoNumber.of(3), LottoNumber.of(17), LottoNumber.of(24), LottoNumber.of(35), LottoNumber.of(44)});

    @Test
    @DisplayName("로또 세트 생성 테스트")
    public void createLotto(){
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(LOTTO_NUMS1));
        lottos.add(new Lotto(LOTTO_NUMS2));
        lottos.add(new Lotto(LOTTO_NUMS3));

        assertThat(lottos.getSize()).isEqualTo(3);
   }

    @Test
    @DisplayName("로또 당첨 테스트")
    public void matchLotto(){
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(LOTTO_NUMS1));
        lottos.add(new Lotto(LOTTO_NUMS2));
        lottos.add(new Lotto(LOTTO_NUMS3));

        assertThat(lottos.getSize()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("로또 당첨 갯수 테스트 (당첨갯수:당첨로또번호)")
    @ValueSource(strings = {"6:1,3,17,24,35,44", "5:2,3,17,24,35,44", "4:2,4,17,24,35,44",
            "3:2,4,15,24,35,44","2:2,4,15,20,35,44","1:2,4,15,20,34,44","0:2,4,15,20,36,45"})
    public void countWinningNumberTest(String input){
        //given
        String[] tokens = input.split(":");
        int expectedMatchedCount = Integer.parseInt(tokens[0]);
        String[] winningNumbers = tokens[1].split(",");

        Lottos lottos = new Lottos();
        lottos.add(new Lotto(LOTTO_NUMS3));

        //when
        Winners winners = lottos.getWinner(new WinningLotto(winningNumbers));

        assertThat(winners.getWinnersCount(Rank.valueOf(Count.of(expectedMatchedCount)))).isEqualTo(Count.of(1));
    }

    @Test
    @DisplayName("로또 당첨 갯수 테스트 ")
    public void countWinningNumberTest2(){
        //given
        String[] winningNumbers = new String[]{"1","2","3","4","5","6"};

        Lottos lottos = new Lottos();
        lottos.add(new Lotto(LOTTO_NUMS1)); // 1,2,3,4,5,6   -> 당첨 6
        lottos.add(new Lotto(LOTTO_NUMS1)); // 1,2,3,4,5,6   -> 당첨 6
        lottos.add(new Lotto(LOTTO_NUMS2)); // 10,13,16,23,45,35 -> 당첨 0
        lottos.add(new Lotto(LOTTO_NUMS3)); // 1,3,17,24,35,44 -> 당첨 2
        //when
        Winners winners = lottos.getWinner(new WinningLotto(winningNumbers));

        assertThat(winners.getWinnersCount(Rank.FIRST)).isEqualTo(Count.of(2));
        assertThat(winners.getWinnersCount(Rank.SECOND)).isEqualTo(Count.ZERO);
        assertThat(winners.getWinnersCount(Rank.THIRD)).isEqualTo(Count.ZERO);
        assertThat(winners.getWinnersCount(Rank.FOURTH)).isEqualTo(Count.ZERO);
        assertThat(winners.getWinnersCount(Rank.MISS)).isEqualTo(Count.of(2));
    }
}
