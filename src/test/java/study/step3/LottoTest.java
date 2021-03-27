package study.step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.step3.domain.Lotto;
import study.step3.domain.LottoNumber;

public class LottoTest {

    @ParameterizedTest(name = "로또 넘버 정렬 테스트")
    @CsvSource(value = {"26,42,7,39,15,1:1,7,15,26,39,42", "36,2,20,3,8,34:2,3,8,20,34,36"}, delimiter = ':')
    public void sort(String inputs, String expected) {
        // given
        String[] inputNumbers = inputs.split(",");
        List<Integer> expectNumbers = Arrays.stream(expected.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        Lotto lotto = new Lotto(inputNumbers);
        // when & then
        assertThat(lotto.getLottoNumbers().toString()).isEqualTo(expectNumbers.toString());
    }

    @ParameterizedTest(name = "로또 넘버 중복 테스트")
    @CsvSource(value={"1,2,3,4,5:5", "1,2,2,3,4:4", "1,2,2,2,3:3"}, delimiter = ':')
    public void duplicate(String inputs, int expected) {
        // given
        String[] inputNumbers = inputs.split(",");
        Lotto lotto = new Lotto(inputNumbers);
        // when & then
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(expected);
    }


    @ParameterizedTest(name = "로또 넘버 맞춤 테스트")
    @CsvSource(value={"1,2,3,4,5:5", "1,2,3,4,10:4", "1,2,3,10,11:3", "1,2,9,10,11:2", "1,13,14,10,11:1", "10,12,13,14,15:0"}, delimiter = ':')
    public void match(String inputs, int expect) {
        // given
        String[] inputNumbers = inputs.split(",");
        Lotto lotto = new Lotto(inputNumbers);
        List<LottoNumber> winInput = new ArrayList<>();
        for(int i = 1; i <= 5; i++) {
            winInput.add(LottoNumber.of(i));
        }
        // when & then
        assertThat(lotto.match(winInput)).isEqualTo(expect);
    }

}
