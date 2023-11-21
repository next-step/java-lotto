package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.model.Lotto;
import step4.model.LottoMake;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMakeTest {

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(3, "1,2,3,4,5,6", List.of(1,2,3,4,5,6)),
                Arguments.of(2,  "11,12,13,14,15,16", List.of(11,12,13,14,15,16)),
                Arguments.of(5,  "17,18,19,20,21,22", List.of(17,18,19,20,21,22)),
                Arguments.of(10,  "23,24,25,26,27,28", List.of(23,24,25,26,27,28))
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("자동 로또 갯수만큼 로또를 생성하고, 수동으로 입력한 로또는 입력받은 숫자 그대로 로또를 생성한다.")
    void lottoMakeTest(int autoLottoCount, String manualLottoNumber, List<Integer> expectedLottoNumbers) {
        LottoMake lottoMake = new LottoMake(autoLottoCount, List.of(manualLottoNumber));
        List<Lotto> lottoAuto = lottoMake.makeAutoLottos();
        List<Lotto> lottoManual = lottoMake.makeManualLottos();

        assertThat(lottoAuto.size()).isEqualTo(autoLottoCount);
        assertThat(lottoManual.get(0).getLottoNumbers().getNumbers()).isEqualTo(expectedLottoNumbers);
    }
}
