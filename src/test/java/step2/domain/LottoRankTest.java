package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "로또 등수 테스트")
class LottoRankTest {

    @ParameterizedTest
    @CsvSource(
            delimiter = '/',
            value = {
                    "6/true/FIRST",
                    "6/false/FIRST",
                    "5/true/SECOND",
                    "5/false/THIRD",
                    "4/true/FOURTH",
                    "4/false/FOURTH",
                    "3/true/FIFTH",
                    "3/false/FIFTH",
                    "2/true/ETC",
                    "2/false/ETC",
                    "1/true/ETC",
                    "1/false/ETC",
                    "0/true/ETC",
                    "0/false/ETC"
            }

    )
    void 맞춘_개수와_보너스_번호_당첨_여부를_입력받아_등수를_계산(long hitCount, boolean isContainBonuNumber, LottoRank expect) {
        assertThat(LottoRank.toRank(hitCount, isContainBonuNumber)).isEqualTo(expect);
    }

}