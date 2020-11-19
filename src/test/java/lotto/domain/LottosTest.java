package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    Lottos lottos;

    @BeforeEach
    void setUp(){
        lottos = Lottos.as(
                LottoUtils.lotto("1,2,3,4,5,6"),
                LottoUtils.lotto("1,2,3,4,5,45"),
                LottoUtils.lotto("1,2,3,4,5,44"),
                LottoUtils.lotto("1,2,3,4,30,45"),
                LottoUtils.lotto("1,2,3,4,30,44"),
                LottoUtils.lotto("1,2,3,20,30,45"),
                LottoUtils.lotto("1,2,3,20,30,44"),
                LottoUtils.lotto("1,2,3,20,30,43"),
                LottoUtils.lotto("1,2,3,4,5,7")
        );
    }

    @DisplayName("당첨번호와 N 개 일치하는 로또를 찾을 수 있다")
    @Test
    void findMatched(){
        // Given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1,2,3,4,5,6), 7);

        // When
        // Then
        assertThat(lottos.finder(winningNumber).findMatched(3).lottos()).hasSize(3);
        assertThat(lottos.finder(winningNumber).findMatched(4).lottos()).hasSize(2);
        assertThat(lottos.finder(winningNumber).findMatched(5).lottos()).hasSize(3);
        assertThat(lottos.finder(winningNumber).findMatched(6).lottos()).hasSize(1);
    }

    @DisplayName("5개가 일치하고 보너스숫자도 일치하는 로또를 찾을 수 있다")
    @Test
    void findMatchedWithBonusNumber(){
        // Given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1,2,3,4,5,6), 7);

        // When
        // Then
        assertThat(lottos.finder(winningNumber).findMatched(5).findMatchBonus().lottos()).hasSize(1);
    }

}
