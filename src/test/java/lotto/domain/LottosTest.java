package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void check_lotto_count(int size) {
        List<Lotto> inputLottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            inputLottos.add(new Lotto(toLottoNumbers("1,2,3,4,5,6")));
        }
        Lottos lottos = new Lottos(inputLottos);
        assertThat(lottos.getCountOfLottos()).isEqualTo(size);
    }

    @Test
    void create() {
        List<Lotto> inputLottos = new ArrayList<>();
        inputLottos.add(new Lotto(toLottoNumbers("1,2,3,4,5,6")));
        Lottos lottos = new Lottos(inputLottos);
        assertThat(lottos.getLotto(0)).isNotNull();
    }

    private List<LottoNumber> toLottoNumbers(String textNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : textNumber.split(",")) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(number.trim())));
        }
        return lottoNumbers;
    }
}
