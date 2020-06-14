package lotto;

import lotto.model.LottoNumber;
import lotto.model.LottoPayment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("로또 번호 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,5",
            "0,1,2,3,4,5",
            "1,2,3,4,5,46",
            "1,2,3,4,5,46,47"})
    void LOTTONUMBER_VALIDATE_TEST(String numbers) {
        
        List<Integer> numberlist = Arrays.asList(numbers.split(",")).stream()
                                        .map(Integer::valueOf)
                                        .collect(Collectors.toList());
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(numberlist);
        });
    }
}
