package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    @DisplayName("숫자로 입력받은 로또는 해당 값들을 가지고 있습니다.")
    void containNumbersTest() {
        List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers numbers = LottoNumbers.valueOf(numberList);
        Lotto lotto = Lotto.of(0, numbers);
        assertThat(lotto.getNumbers()).isEqualTo(numberList);
    }

    @ParameterizedTest
    @CsvSource({"1:2:3:7:8:9,3", "1:2:3:4:5:6,6", "2:3:5:6:8:9,4", "22:23:25:26:28:29,0"})
    @DisplayName("로또 숫자 중에 매칭된 갯수만큼 값을 리턴한다.")
    void getMatchCountTest(String value, String expected) {
        LottoNumbers numbers = LottoNumbers.valueOf(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.of(0, numbers);
        List<Integer> winningNumbers = Arrays.stream(value.split(":")).map(Integer::parseInt).collect(Collectors.toList());
        LottoNumbers targetNumbers = LottoNumbers.valueOf(winningNumbers);
        assertThat(lotto.getMatchCount(targetNumbers)).isEqualTo(Integer.parseInt(expected));
    }

    @Test
    @DisplayName("같은 lottoNum으로 만들어진 로또는 equals true입니다.")
    void equalsTest() {
        LottoNumbers numbers = LottoNumbers.valueOf(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = Lotto.of(0, numbers);
        Lotto lotto2 = Lotto.of(0, numbers);
        assertThat(lotto1).isEqualTo(lotto2);
    }

    @Test
    @DisplayName("다른 lottoNum으로 만들어진 로또는 같은 로또 번호를 가지더라도 equals false입니다.")
    void equalsWithOtherLottoNumTest() {
        LottoNumbers numbers = LottoNumbers.valueOf(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = Lotto.of(0, numbers);
        Lotto lotto2 = Lotto.of(1, numbers);
        assertThat(lotto1).isNotEqualTo(lotto2);
    }


    @Test
    @DisplayName("같은 lottoNum으로 만들어진 로또는 hashCode가 같습니다.")
    void hashCodeTest() {
        LottoNumbers numbers = LottoNumbers.valueOf(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = Lotto.of(0, numbers);
        Lotto lotto2 = Lotto.of(0, numbers);
        assertThat(lotto1.hashCode()).isEqualTo(lotto2.hashCode());
    }
}
