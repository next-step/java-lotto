package lotto;


import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @DisplayName("로또 생성 테스트")
    @Test
    public void 로또생성(){

        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Arrays.asList(-1,2,3,4,5,6));
        }).isInstanceOf(IllegalArgumentException.class);

    }


    @DisplayName("일등 테스트")
    @Test
    public void 일등(){
        assertThat(Rank.valueOf(6).get()).isEqualTo(Rank.FIRST);
    }

    @DisplayName("이등 테스트")
    @Test
    public void 이등(){
        assertThat(Rank.valueOf(5).get()).isEqualTo(Rank.SECOND);
    }

    @DisplayName("삼등 테스트")
    @Test
    public void 삼등(){
        assertThat(Rank.valueOf(4).get()).isEqualTo(Rank.THIRD);
    }

    @DisplayName("사등 테스트")
    @Test
    public void 사등(){
        assertThat(Rank.valueOf(3).get()).isEqualTo(Rank.FOURTH);
    }

}
