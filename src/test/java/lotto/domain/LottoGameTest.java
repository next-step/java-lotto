package lotto.domain;

import lotto.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoGameTest {

    private static final WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

    @Test
    @DisplayName("Lotto game의 결과를 출력한다.")
    void should_return_lotto_game_result() {

        //Given
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottoes lottoes = new Lottoes(Collections.singletonList(lottoNumbers));
        LottoGame lottoGame = new LottoGame(lottoes, winningNumber);

        //When
        LottoGameResult lottoGameResult = lottoGame.getResult();

        //Then
        assertThat(lottoGameResult.getValue().get(Rank.FIRST)).isOne();

    }

}
