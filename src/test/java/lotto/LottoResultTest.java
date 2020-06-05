package lotto;

import lotto.model.LottoPrize;
import lotto.model.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("로또 당첨번호 매칭")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,9,10,11:3",
            "1,2,3,4,10,11:4",
            "1,2,3,4,5,11:5",
            "1,2,3,4,5,6:6",},
            delimiter = ':')
    void LOTTO_WINNER_NUMBER_MATCHING(String lottoNumber, int matchingCount) {
        String[] lastNumber = { "1", "2", "3", "4", "5", "6" };
        List<Integer> userNumber = Arrays.asList(lottoNumber.split(","))
                .stream().map(Integer::parseInt)
                .collect(Collectors.toList());
        assertThat(new LottoResult(lastNumber).checkWinnerNumber(userNumber)).isEqualTo(matchingCount);
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
        String[] lastNumber = { "1", "2", "3", "4", "5", "6" };
        List<Integer> userNumber = Arrays.asList(lottoNumber.split(","))
                .stream().map(Integer::parseInt)
                .collect(Collectors.toList());
        int[] lottoPrize = { LottoPrize.FIRST_PRIZE, LottoPrize.SECOND_PRIZE, LottoPrize.THIRD_PRIZE, LottoPrize.FOURTH_PRIZE };
        int matchingNumber = new LottoResult(lastNumber).checkWinnerNumber(userNumber);
        assertThat(LottoPrize.getLottoPrize(matchingNumber)).isEqualTo(lottoPrize[prizePosition]);
    }

}
