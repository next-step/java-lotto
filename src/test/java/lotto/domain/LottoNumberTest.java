package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName("로또 번호를 생성할 수 있다")
    @Test
    public void newLottoNumberTest() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6);
        LottoNumber one = new LottoNumber(numbers);
        LottoNumber another = new LottoNumber(numbers);

        assertThat(one).isEqualTo(another);
    }

}
