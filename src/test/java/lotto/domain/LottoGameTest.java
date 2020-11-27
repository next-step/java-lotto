package lotto.domain;

import lotto.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoGameTest {

    private static final WinningNumbers WINNING_NUMBERS = new WinningNumbers("1,2,3,4,5,6");

    @Test
    @DisplayName("Lotto game의 결과를 출력한다.")
    void should_return_lotto_game_result() {

        //Given
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        Lottoes lottoes = new Lottoes(Collections.singletonList(lottoNumbers));
        LottoGame lottoGame = new LottoGame(lottoes, WINNING_NUMBERS);

        //When
        List<Rank> result = lottoGame.getResult();

        //Then
        assertThat(result).contains(Rank.FIRST);

    }

}
