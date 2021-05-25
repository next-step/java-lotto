package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.intf.NumbersGenerator;
import lotto.utils.LottoNumbersUtil;

/**
 * LottoMachine 객체 생성 및 로또 생성기능 테스트
 */
public class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "10000:10", "15000:15", "3000:3"}, delimiter = ':')
    @DisplayName("입력한 금액만큼의 로또 개수 생성 확인")
    void create(int price, int lottoCount) {
        // given
        NumbersGenerator numbersGenerator = createNumbersGenerator("1,2,3,4,5,7");
        LottoMachine lottoMachine = new LottoMachine(new Price(price), numbersGenerator);

        // when
        Lottos lottos = lottoMachine.createLottos();

        // then
        assertThat(lottos.getSize()).isEqualTo(lottoCount);
    }

    private NumbersGenerator createNumbersGenerator(String textNumbers) {
        return () -> LottoNumbersUtil.toLottoNumbers(textNumbers);
    }


}
