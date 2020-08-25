package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Winners;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private List<LottoNumber> LOTTO_NUMS1 = Arrays.asList(new LottoNumber[]{new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)});
    private List<LottoNumber> LOTTO_NUMS2 = Arrays.asList(new LottoNumber[]{new LottoNumber(10), new LottoNumber(13), new LottoNumber(16), new LottoNumber(23), new LottoNumber(45), new LottoNumber(35)});
    private List<LottoNumber> LOTTO_NUMS3 = Arrays.asList(new LottoNumber[]{new LottoNumber(1), new LottoNumber(3), new LottoNumber(17), new LottoNumber(24), new LottoNumber(35), new LottoNumber(44)});

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

        List<LottoNumber> winningNums = LottoNumber.makeLottoNums(winningNumbers);

        Lottos lottos = new Lottos();
        lottos.add(new Lotto(LOTTO_NUMS3));

        //when
        Winners winners = lottos.getWinner(winningNums);

        assertThat(winners.getWinnersCount(expectedMatchedCount)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 갯수 테스트 (당첨갯수:당첨로또번호)")
    public void countWinningNumberTest2(){
        //given
        String[] winningNumbers = new String[]{"1","2","3","4","5","6"};

        List<LottoNumber> winningNums = LottoNumber.makeLottoNums(winningNumbers);

        Lottos lottos = new Lottos();
        lottos.add(new Lotto(LOTTO_NUMS1)); // 1,2,3,4,5,6   -> 당첨 6
        lottos.add(new Lotto(LOTTO_NUMS1)); // 1,2,3,4,5,6   -> 당첨 6
        lottos.add(new Lotto(LOTTO_NUMS2)); // 10,13,16,23,45,35 -> 당첨 0
        lottos.add(new Lotto(LOTTO_NUMS3)); // 1,3,17,24,35,44 -> 당첨 2
        //when
        Winners winners = lottos.getWinner(winningNums);

        assertThat(winners.getWinnersCount(6)).isEqualTo(2);
        assertThat(winners.getWinnersCount(5)).isEqualTo(0);
        assertThat(winners.getWinnersCount(4)).isEqualTo(0);
        assertThat(winners.getWinnersCount(3)).isEqualTo(0);
        assertThat(winners.getWinnersCount(2)).isEqualTo(1);
        assertThat(winners.getWinnersCount(1)).isEqualTo(0);
        assertThat(winners.getWinnersCount(0)).isEqualTo(1);
    }
}
