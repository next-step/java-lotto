package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {


    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 번호_개수_validation(String numbers) {

        List<Integer> lottoNumbers = Arrays.asList(numbers.split(",")).stream()
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("로또 번호는 6자리여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:0", "1,2,3,4,5,30:1", "1,2,3,4,30,31:2"
            , "1,2,3,30,32,33:3", "1,2,30,32,33,34:4", "1,30,31,32,33,34:5", "30,31,32,33,34,35:6"}
            , delimiter = ':')
    void 일치하는_번호_개수_테스트(String numbers, int matchingCount) {

        List<Integer> myLottoNumbers = Arrays.asList(numbers.split(",")).stream()
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
        List<Integer> answer = Arrays.asList(30, 31, 32, 33, 34, 35);
        Lotto lotto = new Lotto(myLottoNumbers);

        assertThat(lotto.matchingCount(answer)).isEqualTo(matchingCount);
    }

    @Test
    @DisplayName("2등, 3등 테스트")
    void second_or_third(){
        Lotto myLottoNumbers1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto myLottoNumbers2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        WinningNumber answer = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 8), 6);

        assertThat(myLottoNumbers1.winningPrice(answer)).isEqualTo(WinningPrice.SECOND);
        assertThat(myLottoNumbers2.winningPrice(answer)).isEqualTo(WinningPrice.THIRD);
    }

}



