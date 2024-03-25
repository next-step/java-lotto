package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @DisplayName("생성한 로또는 6개 숫자를 가져야함.")
    @Test
    void num_lotto(){
        List<Integer> randomList = new ArrayList<>(Arrays.asList(1, 2, 3 , 4, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            new Lotto(randomList));
    }

    @DisplayName("생성한 로또는 중복원소를 가지면 안된다.")
    @Test
    void duplication_lotto(){
        List<Integer> randomList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Lotto(randomList));
    }

    @DisplayName("당첨 개수 확인")
    @Test
    void match_lotto(){
        Lotto lottoBuy = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3 , 4, 5, 8)));
        Lotto lottopicked = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3 , 4, 5, 6)));
        BonusNum bonus = new BonusNum(7);
        WinLotto lotto = new WinLotto(lottopicked, bonus);
        assertThat(lottoBuy.numMatch(lotto.getWinLottoNum(),lotto.getBonusNum())).isEqualTo(RankMatches.THIRD);

        Lotto lottoBuy2 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3 , 4, 5, 7)));
        assertThat(lottoBuy2.numMatch(lotto.getWinLottoNum(),lotto.getBonusNum())).isEqualTo(RankMatches.SECOND);
    }



}
