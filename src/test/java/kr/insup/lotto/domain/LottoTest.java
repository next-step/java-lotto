package kr.insup.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("당첨 번호 1등 테스트")
    @Test
    void 당첨_번호_1등_테스트(){
        //given
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when
        assertThat(lotto.matchWinningNumber(winningNumbers)).isEqualTo(Place.First);
    }

    @DisplayName("당첨 번호 2등 테스트")
    @Test
    void 당첨_번호_2등_테스트(){
        //given
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when
        assertThat(lotto.matchWinningNumber(winningNumbers)).isEqualTo(Place.Second);
    }

    @DisplayName("당첨 번호 3등 테스트")
    @Test
    void 당첨_번호_3등_테스트(){
        //given
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 7, 8);
        //when
        assertThat(lotto.matchWinningNumber(winningNumbers)).isEqualTo(Place.Third);
    }

    @DisplayName("당첨 번호 4등 테스트")
    @Test
    void 당첨_번호_4등_테스트(){
        //given
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        //when
        assertThat(lotto.matchWinningNumber(winningNumbers)).isEqualTo(Place.Fourth);
    }

    @DisplayName("아무것도 당첨 안됨 테스트")
    @Test
    void 아무것도_당첨_안됨_테스트(){
        //given
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 7, 8, 9, 10);
        //when
        assertThat(lotto.matchWinningNumber(winningNumbers)).isEqualTo(Place.None);
    }

}
