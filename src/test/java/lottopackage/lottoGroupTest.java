package lottopackage;

import lottopackage.domain.Lotto;
import lottopackage.domain.LottoBall;
import lottopackage.domain.LottoGroup;
import lottopackage.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class lottoGroupTest {

    @Test
    @DisplayName("LottoGroup 내 모든 Lotto의 당첨 등수 확인")
    public void isPrize() {
        // given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add( new Lotto( new HashSet<>( Arrays.asList(1, 2, 3, 4, 5, 6) ) ) ); // 1st
        lottoList.add( new Lotto( new HashSet<>( Arrays.asList(1, 2, 3, 4, 5, 7) ) ) ); // 3rd
        lottoList.add( new Lotto( new HashSet<>( Arrays.asList(1, 2, 3, 4, 7, 8) ) ) ); // 4th
        lottoList.add( new Lotto( new HashSet<>( Arrays.asList(1, 2, 3, 7, 8, 9) ) ) ); // 5th
        lottoList.add( new Lotto( new HashSet<>( Arrays.asList(11, 12, 13, 14, 15, 16) ) ) ); // 6th

        LottoGroup lottoGroup = new LottoGroup(lottoList);

        // when
        Set<LottoBall> winningNumber = new Lotto( new HashSet<>( Arrays.asList(1, 2, 3, 4, 5, 6))).getLotto();
        List<Prize> prizes = lottoGroup.isWinning(winningNumber);
        Prize[] prizeGroup = Prize.values();

        // then
        for (int i = 0; i < prizes.size(); i++) {
            Assertions.assertThat(prizes.get(i)).isEqualTo(prizeGroup[i]);
            System.out.println(prizes.get(i).name());
        }
    }
}
