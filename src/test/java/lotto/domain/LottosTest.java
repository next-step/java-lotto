package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("당첨번호와 N 개 일치하는 로또를 찾을 수 있다")
    @Test
    void findMatched(){
        // Given
        Lottos lottos = new Lottos(
                myLotto(1,2,3,4,5,6),
                myLotto(1,2,3,4,5,45),
                myLotto(1,2,3,4,5,44),
                myLotto(1,2,3,4,30,45),
                myLotto(1,2,3,4,30,44),
                myLotto(1,2,3,20,30,45),
                myLotto(1,2,3,20,30,44),
                myLotto(1,2,3,20,30,43)
        );
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1,2,3,4,5,6));

        // When
        // Then
        assertThat(lottos.findMatched(winningNumber, 3)).hasSize(3);
        assertThat(lottos.findMatched(winningNumber, 4)).hasSize(2);
        assertThat(lottos.findMatched(winningNumber, 5)).hasSize(2);
        assertThat(lottos.findMatched(winningNumber, 6)).hasSize(1);
    }

    private Lotto myLotto(int i, int i1, int i2, int i3, int i4, int i5) {
        return new Lotto(new LottoNumber(Arrays.asList(i,i1,i2,i3,i4,i5)));
    }

}
