package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private static final int LOTTO_LENGTH = 6;

    @Test
    void lotto() {
        List<LottoNumber> lottoNumber=makeLottoNumber();
        Lotto lotto = new Lotto(lottoNumber);
        assertThat(lotto.lottoNum()).isEqualTo(lottoNumber);
    }

    private List<LottoNumber> makeLottoNumber() {
        List<LottoNumber> lotto = new ArrayList<>();
        for (int i = 0; i < LOTTO_LENGTH; i++) {
            lotto.add(new LottoNumber(i + 1));
        }
        return lotto;
    }


}