package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    Lotto lotto = new Lotto();

    @DisplayName("로또 생성 테스트")
    @Test
    void LOTTO_NUMBER_COUNT() {
        assertThat(new Lotto().getLottoNumbers(5)).hasSize(5);
    }

    @DisplayName("로또 당첨번호 매칭")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,9,10,11:3",
            "1,2,3,4,10,11:4",
            "1,2,3,4,5,11:5",
            "1,2,3,4,5,6:6",},
            delimiter = ':')
    void LOTTO_WINNER_NUMBER_MATCHING(String lottoNumber, int matchingCount) {
        String[] winnerNumber = { "1", "2", "3", "4", "5", "6" };
        String[] userNumber = lottoNumber.split(",");
        assertThat(lotto.checkWinnerNumber(winnerNumber, userNumber)).isEqualTo(matchingCount);
    }

    @DisplayName("로또 당첨금 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,9,10,11:3",
            "1,2,3,4,10,11:2",
            "1,2,3,4,5,11:1",
            "1,2,3,4,5,6:0",},
            delimiter = ':')
    void LOTTO_WINNER_PRIZE_TEST(String lottoNumber, int prizePosition) {
        String[] winnerNumber = { "1", "2", "3", "4", "5", "6" };
        String[] userNumber = lottoNumber.split(",");
        int[] lottoPrize = { Lotto.FIRST_PRIZE, Lotto.SECOND_PRIZE, Lotto.THIRD_PRIZE, Lotto.FOURTH_PRIZE };
        int matchingNumber = lotto.checkWinnerNumber(winnerNumber, userNumber);
        assertThat(lotto.getLottoPrize(matchingNumber)).isEqualTo(lottoPrize[prizePosition]);
    }
}
