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
        assertThat(lotto.getLottoNumbers()).isEqualTo(lottoNumbers);
    }

}