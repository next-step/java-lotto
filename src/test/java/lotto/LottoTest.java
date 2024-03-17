package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @DisplayName("로또 번호는 1~45 사이")
    @Test
    void random_num(){
        RandomGenerator randomGenerator = new RandomGenerator();
    }

    @DisplayName("생성한 로또는 6개 숫자를 가져야함.")
    @Test
    void num_lotto(){
        Lotto lotto = new Lotto();
        lotto.oneLotto();
        assertThat(lotto.numOfLotto()).isEqualTo(6);
    }

    @DisplayName("당첨 개수 확인")
    @Test
    void match_lotto(){
        Lotto lottoBuy = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3 , 4, 5, 6)));
        Lotto lottopicked = new Lotto(new ArrayList<>(Arrays.asList(11, 22, 3 , 4, 5, 6)));
        assertThat(lottoBuy.numMatch(lottopicked)).isEqualTo(4);
    }



}
