package lotto;

import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"6: 2000000000",
            "5:1500000",
            "4:50000",
            "3:5000",
            "0:0"}
            , delimiter = ':')
    void RankTest(String countOfMatch, int winningMoney) {
        int intCountOfMatch = Integer.parseInt(countOfMatch);
        assertThat(Rank.of(intCountOfMatch).getWinningMoney()).isEqualTo(winningMoney);
    }

    @Test
    void Rank생성실패() {
        assertThatIllegalArgumentException().isThrownBy(()->{
           Rank rank = Rank.of(100);
        });
    }
}
