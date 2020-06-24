package step4.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("입력번호에 맞는 로또 생성")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,5,6", "2,4,6,8,10,45:2,4,6,8,10,45", "1,2,3,43,44,45:1,2,3,43,44,45"}, delimiter = ':')
    public void getBoughtLottoCount(String inputString, String resultString) {
        Lotto lotto = new Lotto(inputString);
        Set<LottoNumber> testResult = Arrays.asList(resultString.split(LottoNumber.FIXED_DELIMITER))
                .stream()
                .map(x -> LottoNumber.of(Integer.valueOf(x)))
                .collect(Collectors.toSet());

        assertThat(lotto.getNumbers()).isEqualTo(testResult);
    }


    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,5,6", "2,4,6,8,10,45:2,4,6,8,10,45", "1,2,3,43,44,45:1,2,3,43,44,45"}, delimiter = ':')
    public void LottoCount(String inputString, String resultString) {
        Lotto lotto = new Lotto(inputString);

        System.out.println(lotto.getNumbers().toString());

        //assertThat(lotto.getNumbers()).isEqualTo(testResult);
    }

}
