package lottopackage;

import lottopackage.domain.Lotto;
import lottopackage.domain.LottoGroup;
import lottopackage.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lottoGroupTest {

    @Test
    @DisplayName("LottoGroup")
    public void isPrize() {
        // given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add( new Lotto( new ArrayList<Integer>( Arrays.asList(1, 2, 3, 4, 5, 6) ) ) );
        lottoList.add( new Lotto( new ArrayList<Integer>( Arrays.asList(1, 2, 3, 4, 5, 7) ) ) );
        lottoList.add( new Lotto( new ArrayList<Integer>( Arrays.asList(1, 2, 3, 4, 7, 8) ) ) );
        lottoList.add( new Lotto( new ArrayList<Integer>( Arrays.asList(1, 2, 3, 7, 8, 9) ) ) );
        lottoList.add( new Lotto( new ArrayList<Integer>( Arrays.asList(11, 12, 13, 14, 15, 16) ) ) );

        LottoGroup lottoGroup = new LottoGroup(lottoList);

        // when
        List<Integer> winningNumber = new ArrayList<>( Arrays.asList(1, 2, 3, 4, 5, 6) );
        List<Prize> prizes = lottoGroup.isWinning(winningNumber);
        Prize[] prizeGroup = Prize.values();

        // then
        for (int i = 0; i < prizes.size(); i++) {
            Assertions.assertThat(prizes.get(i)).isEqualTo(prizeGroup[i]);
            System.out.println(prizes.get(i).name());
        }

    }

}
