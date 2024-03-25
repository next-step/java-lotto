package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    void compare_to_bigger_and_smaller() {
        LottoNumber bigger = new LottoNumber(5);
        LottoNumber standard = new LottoNumber(4);
        LottoNumber smaller = new LottoNumber(3);

        int lower = standard.compareTo(bigger);
        int upper = standard.compareTo(smaller);

        assertThat(lower).isEqualTo(-1);
        assertThat(upper).isEqualTo(1);
    }
}