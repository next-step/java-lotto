package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFullNumberTest {

    @DisplayName("로또_숫자_중복_테스트")
    @Test
    void Lotto_Full_Number_Duplication_Test() {
        List<Integer> number = Arrays.asList(42, 21, 23, 41, 42, 43);
        List<LottoNumber> lottoNumber = number.stream().map(LottoNumber::new).collect(Collectors.toList());
        assertThatIllegalArgumentException()
            .isThrownBy(()->new LottoNumbers(lottoNumber));
    }
}
