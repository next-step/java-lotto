package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Lottos 클래스 생성 및 기능 테스트
 */
public class LottosTest {

    LottoNumbersGenerator lottoNumbersGenerator;

    @BeforeEach
    public void beforeEach() {
        this.lottoNumbersGenerator = new LottoNumbersGenerator();
    }

    @ParameterizedTest
    @CsvSource(value = {"6:1", "5:0", "4:2", "3:1"}, delimiter = ':')
    @DisplayName("로또 통계 결과 확인")
    void get_matchedNumber(int matchingNumber, int count) {
        // given
        List<Lotto> inputLottos = new ArrayList<>();
        LottoNumbers winningLottoNumbers = this.lottoNumbersGenerator.toLottoNumbers("1,2,3,4,5,6");
        inputLottos.add(new Lotto(this.lottoNumbersGenerator.toLottoNumbers("1,2,3,4,5,6")));
        inputLottos.add(new Lotto(this.lottoNumbersGenerator.toLottoNumbers("3,4,5,6,7,8")));
        inputLottos.add(new Lotto(this.lottoNumbersGenerator.toLottoNumbers("3,4,5,6,7,8")));
        inputLottos.add(new Lotto(this.lottoNumbersGenerator.toLottoNumbers("4,5,6,7,8,9")));
        inputLottos.add(new Lotto(this.lottoNumbersGenerator.toLottoNumbers("5,6,7,8,9,10")));
        Lottos lottos = new Lottos(inputLottos);

        // when
        LottoStatistics lottoStatistics = lottos.getLottoStatisticsByWinningNumbers(winningLottoNumbers);

        // then
        assertThat(lottoStatistics.getCountOfLottoWithMatchingNumber(matchingNumber)).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    @DisplayName("생성된 로또의 개수 확인")
    void check_lotto_count(int size) {
        // given
        List<Lotto> inputLottos = new ArrayList<>();

        // when
        for (int i = 0; i < size; i++) {
            inputLottos.add(new Lotto(this.lottoNumbersGenerator.toLottoNumbers("1,2,3,4,5,6")));
        }
        Lottos lottos = new Lottos(inputLottos);

        // then
        assertThat(lottos.getSize()).isEqualTo(size);
    }

    @Test
    @DisplayName("객체 생성")
    void create() {
        // given
        List<Lotto> inputLottos = new ArrayList<>();

        // when
        inputLottos.add(new Lotto(this.lottoNumbersGenerator.toLottoNumbers("1,2,3,4,5,6")));
        Lottos lottos = new Lottos(inputLottos);

        // then
        assertThat(lottos.getLotto(0)).isNotNull();
    }
}
