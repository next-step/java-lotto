package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NormalLottoTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6,1:false",
            "1,2,3,4,5:false",
            "1,2,3,4:10:false",
            "1,2,3,3,4,5:false",
            "-1,1,2,3,4,5:false",
            "1,2,3,4,5,46:false",
            "1,2,3,4,5,6,7:false",
            "1,2,3,4,5,6:true",
            "40,41,42,43,44,45:true"}, delimiter = ':')
    @DisplayName("로또가 올바른지 판단할 수 있다")
    void determinesValidLotto(String rawLotto, boolean expected) {
        NormalLotto normalLotto = new NormalLotto();
        boolean valid = normalLotto.valid(Arrays.stream(rawLotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        assertThat(valid).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6,1:false",
            "1,2,3,4,5:false",
            "1,2,3,4:10:false",
            "1,2,3,3,4,5:false",
            "-1,1,2,3,4,5:false",
            "1,2,3,4,5,46:false",
            "1,2,3,4,5,6,7:false"}, delimiter = ':')
    @DisplayName("로또가 올바르지 않으면 생성자에서 에러를 던진다")
    void invalidLottoThrowsException(String rawLotto, boolean expected) {
        List<Integer> numbers = Arrays.stream(rawLotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        assertThrows(IllegalArgumentException.class, () -> new NormalLotto(numbers));
    }
}
