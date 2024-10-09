package lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("맞은 로또 번호 갯수를 저장할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void newLottoResult(int hitCount) {
        LottoResult lottoResult = new LottoResult(hitCount);

        assertThat(lottoResult).isEqualTo(new LottoResult(hitCount));
    }

    @DisplayName("맞은 로또 번호 갯수를 조회할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void getMatchedLottoNumbersCount(int hitCount) {
        LottoResult lottoResult = new LottoResult(hitCount);

        assertThat(lottoResult.getMatchedLottoNumbersCount()).isEqualTo(hitCount);
    }
}