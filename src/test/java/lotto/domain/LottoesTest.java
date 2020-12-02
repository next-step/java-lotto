package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoesTest {

    private static final WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", 7);
    private static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @Test
    @DisplayName("Lotto 번호가 6개 모두 일치 할 경우 1등의 결과를 출력한다.")
    void should_return_lotto_game_result() {

        //Given
        LottoNumbers lottoNumbers = lottoNumberGenerator.create("1, 2, 3, 4, 5, 6");
        Lottoes lottoes = new Lottoes(Arrays.asList(lottoNumbers));

        //When
        LottoGameResult result = lottoes.getResult(winningNumbers);

        //Then
        assertThat(result.getRanks().containsKey(Rank.FIRST)).isTrue();

    }

}