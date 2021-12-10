package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void create_lotto_with_6_numbers() {
        // given
        List<Number> lottoNumbers = new ArrayList<Number>() {{
            add(new Number(1));
            add(new Number(2));
            add(new Number(3));
            add(new Number(4));
            add(new Number(5));
            add(new Number(6));
        }};

        // when
        Lotto lotto = new Lotto(lottoNumbers);

        // then
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void count_match() {
        // given
        Lotto other = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto current = new Lotto("1, 2, 3, 4, 5, 7");

        // when
        int count = current.countMatch(other);

        // then
        assertThat(count).isEqualTo(5);
    }

}