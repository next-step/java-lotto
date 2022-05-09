package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "로또 등수 테스트")
class LottoRankTest {

    @ParameterizedTest
    @CsvSource(
            delimiter = '/',
            value = {
                    "1, 2, 3, 4, 5, 6/7/FIRST",
                    "1, 2, 3, 4, 5, 16/6/SECOND",
                    "1, 2, 3, 4, 5, 16/7/THIRD",
                    "1, 2, 3, 4, 15, 16/7/FOURTH",
                    "1, 2, 3, 14, 15, 16/7/FIFTH",
                    "1, 2, 13, 14, 15, 16/7/ETC",
                    "1, 12, 13, 14, 15, 16/7/ETC",
                    "11, 12, 13, 14, 15, 16/7/ETC"
            }

    )
    void 로또와_당첨_객체를_받아서_등수를_계산(String winnerNumber, String bonusNumber, LottoRank expect) {
        PurchaseStrategy strategy = (count) -> new HashSet<>(List.of("1", "2", "3", "4", "5", "6"));
        Lotto lotto = new Lotto(strategy);
        WinningLotto winningLotto = new WinningLotto(winnerNumber, bonusNumber);

        LottoRank result = LottoRank.toRank(lotto, winningLotto);

        assertThat(result).isEqualTo(expect);
    }

}