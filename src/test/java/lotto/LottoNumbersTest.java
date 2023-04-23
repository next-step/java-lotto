package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
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

    @ParameterizedTest(name = "{0}으로 구성된 LottoNumbers는 {1}개의 숫자를 맞춘다.")
    @CsvSource(
            value = {
                    "1,2,3,4,5,6:6",
                    "1,2,3,4,5,7:5",
                    "7,8,1,2,3,4:4",
                    "9,2,3,4,8,7:3",
                    "10,2,13,14,15,6:2"
            },
            delimiter = ':'
    )
    public void match(String inputs, int expected) {
        LottoNumbers lottoNumbers = new LottoNumbers(
                Set.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )
        );

        Set<LottoNumber> set = new HashSet<>();
        for (String s : inputs.split(",")) {
            set.add(new LottoNumber(Integer.parseInt(s)));
        }

        assertThat(lottoNumbers.match(new LottoNumbers(set))).isEqualTo(expected);
    }
}
