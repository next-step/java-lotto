package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private List<LottoNumber> LOTTO_NUMS1 = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    private List<LottoNumber> LOTTO_NUMS2 = Arrays.asList(LottoNumber.of(10), LottoNumber.of(13), LottoNumber.of(16), LottoNumber.of(23), LottoNumber.of(45), LottoNumber.of(35));
    private List<LottoNumber> LOTTO_NUMS3 = Arrays.asList(LottoNumber.of(1), LottoNumber.of(3), LottoNumber.of(17), LottoNumber.of(24), LottoNumber.of(35), LottoNumber.of(44));
    private List<LottoNumber> LOTTO_NUMS4 = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(7));
    private List<LottoNumber> LOTTO_NUMS5 = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(8));

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

    @Test
    @DisplayName("로또 당첨 갯수 테스트 ")
    public void countWinningNumberTest2(){
        //given
        String[] winningNumbers = new String[]{"1","2","3","4","5","6"};
        int bonumsNumber = 8;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonumsNumber);

        Lottos lottos = new Lottos();
        lottos.add(new Lotto(LOTTO_NUMS1)); // 1,2,3,4,5,6   -> 당첨 6
        lottos.add(new Lotto(LOTTO_NUMS2)); // 10,13,16,23,45,35 -> 당첨 0
        lottos.add(new Lotto(LOTTO_NUMS3)); // 1,3,17,24,35,44 -> 당첨 2
        lottos.add(new Lotto(LOTTO_NUMS4)); // 1,2,3,4,5,7   -> 당첨 5 / 보너스 X
        lottos.add(new Lotto(LOTTO_NUMS5)); // 1,2,3,4,5,8   -> 당첨 5 / 보너스 O

        //when
        Winners winners = lottos.getWinner(winningLotto);

        assertThat(winners.getWinnersCount(Rank.FIRST)).isEqualTo(Count.of(1));
        assertThat(winners.getWinnersCount(Rank.SECOND)).isEqualTo(Count.of(1));
        assertThat(winners.getWinnersCount(Rank.THIRD)).isEqualTo(Count.of(1));
        assertThat(winners.getWinnersCount(Rank.FOURTH)).isEqualTo(Count.ZERO);
        assertThat(winners.getWinnersCount(Rank.MISS)).isEqualTo(Count.of(2));
    }
}
