package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @DisplayName("로또_숫자_범위_유효_테스트")
    @Test
    void LottoNumberRangeTest() {
        List<Integer> number = Arrays.asList(-2, 21, 23, 41, 42, 43);
        assertThatIllegalArgumentException()
            .isThrownBy(() -> number.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }
}
