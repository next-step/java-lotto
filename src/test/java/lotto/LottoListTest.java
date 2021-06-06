package lotto;

import lotto.domain.Lotto;
import lotto.domain.config.NumberSize;
import lotto.domain.entity.LottoList;
import lotto.domain.entity.Number;
import lotto.domain.generator.LottoNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {

    private LottoNumbersGenerator lottoNumbersGenerator;

    @BeforeEach
    public void setUp() {
        lottoNumbersGenerator = new TestGenerator();
    }

    @Test
    @DisplayName("로또 생성기와 구매한 로또 비교하기")
    public void 로또_비교하기() {
        LottoList generateLottoList = new LottoList(1, lottoNumbersGenerator);
        LottoList constructLottoList = new LottoList(new Lotto(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6)));
        assertThat(generateLottoList).isEqualTo(constructLottoList);
    }

    @Test
    @DisplayName("구매 금액이나 로또 여러장으로 LottoList 를 생성한다.")
    public void 로또_생성자_확인() {
        LottoList amountLotto = new LottoList(5, lottoNumbersGenerator);
        assertThat(amountLotto.size()).isEqualTo(5);

        LottoList arrayLotto = new LottoList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        assertThat(arrayLotto.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 한장을 정상적으로 반환하는지 확인한다.")
    public void 로또_가져오기() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoList lottoList = new LottoList(lotto);
        assertThat(lottoList.get(0)).isEqualTo(lotto);
    }

    static class TestGenerator implements LottoNumbersGenerator {

        @Override
        public List<Number> generateNumber() {
            return Arrays.asList(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6));
        }

        @Override
        public void sortNumbers(List<Number> lottoNumbers) {
            Collections.sort(lottoNumbers);
        }
    }
}
