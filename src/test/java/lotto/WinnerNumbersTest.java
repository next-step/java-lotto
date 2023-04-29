package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinnerNumbers;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerNumbersTest {
    private WinnerNumbers winnerNumbers = new WinnerNumbers(
            Set.of(
                    LottoNumber.valueOf(1),
                    LottoNumber.valueOf(2),
                    LottoNumber.valueOf(3),
                    LottoNumber.valueOf(4),
                    LottoNumber.valueOf(5),
                    LottoNumber.valueOf(6)
            ),
            LottoNumber.valueOf(7)
    );
    @Test
    public void create() {
        WinnerNumbers create = new WinnerNumbers(
                Set.of(
                        LottoNumber.valueOf(1),
                        LottoNumber.valueOf(2),
                        LottoNumber.valueOf(3),
                        LottoNumber.valueOf(4),
                        LottoNumber.valueOf(5),
                        LottoNumber.valueOf(6)
                ),
                LottoNumber.valueOf(7));
        assertThat(winnerNumbers).isEqualTo(create);
    }

    @ParameterizedTest(name = "{0},{1}로 구성된 LottoNumbers의 Rank는 {2}입니다.")
    @CsvSource(
            value = {
                    "1,2,3,4,5,6:FIRST",
                    "1,2,3,4,5,7:SECOND",
                    "1,2,3,4,5,9:THIRD",
                    "7,8,1,2,3,4:FOURTH",
                    "9,2,3,4,8,7:FIFTH",
                    "10,2,13,14,15,6:MISS"
            },
            delimiter = ':'
    )
    public void match(
            String inputs,
            String expectedRank
    ) {
        Set<LottoNumber> set = new HashSet<>();
        for (String s : inputs.split(",")) {
            set.add(LottoNumber.valueOf(Integer.parseInt(s)));
        }
        LottoNumbers lottoNumbers = new LottoNumbers(set);

        Rank rank = winnerNumbers.match(lottoNumbers);
        assertThat(rank).isEqualTo(Rank.from(expectedRank));
    }
}
