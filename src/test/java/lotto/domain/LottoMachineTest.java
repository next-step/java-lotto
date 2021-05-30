package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    @CsvSource(value = {"0:1,2,3,4,5,6", "1:2,3,4,5,6,7", "2:10,11,12,13,14,15", "9:10,11,12,13,14,15"}, delimiter = ':')
    @DisplayName("수동 로또번호 입력 시 테스트")
    void manualLotto(int index, String textResultLottoNumbers) {
        // given
        List<LottoNumbers> manualNumbers = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7").stream()
                .map(LottoNumbersUtil::toLottoNumbers)
                .collect(Collectors.toList());
        LottoMachine lottoMachine = new LottoMachine(createNumbersGenerator("10,11,12,13,14,15"));

        // when
        Lottos lottos = lottoMachine.createLottos(new Price(10000), manualNumbers);

        // then
        assertThat(lottos.getLottoNumbers(index).getCountOfMatchingNumber(LottoNumbersUtil.toLottoNumbers(textResultLottoNumbers))).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "10000:10", "15000:15", "3000:3"}, delimiter = ':')
    @DisplayName("입력한 금액만큼의 로또 개수 생성 확인")
    void create(int price, int lottoCount) {
        // given
        NumbersGenerator numbersGenerator = createNumbersGenerator("1,2,3,4,5,7");
        LottoMachine lottoMachine = new LottoMachine(numbersGenerator);

        // when
        Lottos lottos = lottoMachine.createLottos(new Price(price), new ArrayList<LottoNumbers>());

        // then
        assertThat(lottos.getSize()).isEqualTo(lottoCount);
    }

    private NumbersGenerator createNumbersGenerator(String textNumbers) {
        return () -> LottoNumbersUtil.toLottoNumbers(textNumbers);
    }
}
