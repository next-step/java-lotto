package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    void getRandomLottoNumber() {
        List<LottoNumber> lotto = LottoNumber.getRandomNumber(Lotto.LOTTO_NUMBER_COUNT);

        assertThat(lotto.size()).isEqualTo(Lotto.LOTTO_NUMBER_COUNT);
    }

}
