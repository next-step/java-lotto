package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LottoNumbersTest {
    @Test
    public void equals() {
        Set<LottoNumber> set1 = new HashSet<>(
                List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )
        );
        LottoNumbers lottoNumbers1 = new LottoNumbers(set1);

        Set<LottoNumber> set2 = new HashSet<>(
                List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )
        );
        LottoNumbers lottoNumbers2 = new LottoNumbers(set2);
        assertThat(lottoNumbers1).isEqualTo(lottoNumbers2);
    }

    @ParameterizedTest(name = "{0},{1}로 구성된 WinnerNumbers에 매칭 결과는, count = {2}, bonus  = {3}입니다.")
    @CsvSource(
            value = {
                    "1,2,3,4,5,6:7:6:false",
                    "1,2,3,4,5,7:7:5:true",
                    "1,2,3,4,5,9:7:5:false",
                    "7,8,1,2,3,4:7:4:true",
                    "9,2,3,4,8,7:7:3:true",
                    "10,2,13,14,15,6:7:2:false"
            },
            delimiter = ':'
    )
    public void match(
            String inputs,
            int bonusNumber,
            int count,
            boolean bonus
    ) {
        WinnerNumbers winnerNumbers = new WinnerNumbers(
                Set.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                ),
                new BonusNumber(bonusNumber)
        );

        Set<LottoNumber> set = new HashSet<>();
        for (String s : inputs.split(",")) {
            set.add(new LottoNumber(Integer.parseInt(s)));
        }
        LottoNumbers lottoNumbers = new LottoNumbers(set);

        MatchResult match = lottoNumbers.match(winnerNumbers);
        assertThat(match.getCount()).isEqualTo(count);
        assertThat(match.getIsBonus()).isEqualTo(bonus);
    }

    @Test
    public void contains() {
        Set<LottoNumber> set1 = new HashSet<>(
                List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )
        );
        LottoNumbers lottoNumbers1 = new LottoNumbers(set1);
        assertThat(lottoNumbers1.contains(new LottoNumber(1))).isTrue();
        assertThat(lottoNumbers1.contains(new LottoNumber(11))).isFalse();
    }
}
