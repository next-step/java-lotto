package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoesTest {

    private static final WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", 7);
    private static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @Test
    @DisplayName("Lotto 번호가 6개 모두 일치 할 경우 1등의 결과를 출력한다.")
    void should_return_lotto_game_result() {

        //Given
        Lottoes lottoes = new Lottoes(new PurchaseAmount(1000), Arrays.asList("1, 2, 3, 4, 5, 6"));

        //When
        LottoGameResult result = lottoes.getResult(winningNumbers);

        //Then
        assertThat(result.getRanks().containsKey(Rank.FIRST)).isTrue();

    }



}
