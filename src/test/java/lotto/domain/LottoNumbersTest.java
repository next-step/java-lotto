package lotto.domain;

import lotto.exception.NotNumberRangeException;
import lotto.strategy.TestLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class LottoNumbersTest {

    @Test
    @ValueSource(ints = {0, 46})
    @DisplayName("실패 - 로또의 숫자가 1 ~ 45범위가 아니면 로또번호는 생성되지 않는다. ")
    void fail_not_range_lotto_number(){
        TestLottoGenerator testLottoGenerator = new TestLottoGenerator(List.of(0, 2, 3, 4, 5, 46));

        Assertions.assertThatThrownBy(() -> new LottoNumbers(testLottoGenerator))
                .isInstanceOf(NotNumberRangeException.class)
                .hasMessage("로또 숫자는 1부터 45까지 입니다.");
    }

}
