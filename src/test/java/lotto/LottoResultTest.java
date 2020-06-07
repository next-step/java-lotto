package lotto;

import lotto.model.LottoResult;
import lotto.model.Rank;
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
            "3:3",
            "4:4",
            "5:5",
            "6:6",},
            delimiter = ':')
    void LOTTO_WINNER_NUMBER_MATCHING(String lottoNumber, int matchingCount) {
        List<Integer> userNumber = Arrays.asList(lottoNumber.split(","))
                .stream().map(Integer::parseInt)
                .collect(Collectors.toList());
        Rank rank = new LottoResult(userNumber).getLottoResult().get(0);

        assertThat(rank).isEqualTo(Rank.valueOf(matchingCount, false));
        assertThat(rank.getWinningMoney()).isEqualTo(Rank.valueOf(matchingCount, false).getWinningMoney());
    }

}
