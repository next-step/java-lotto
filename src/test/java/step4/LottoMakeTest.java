package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.model.Lotto;
import step4.model.LottoAutoMake;
import step4.model.LottoCount;
import step4.model.LottoManualMake;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMakeTest {

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", List.of(1,2,3,4,5,6)),
                Arguments.of("11,12,13,14,15,16", List.of(11,12,13,14,15,16)),
                Arguments.of("17,18,19,20,21,22", List.of(17,18,19,20,21,22)),
                Arguments.of("23,24,25,26,27,28", List.of(23,24,25,26,27,28))
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("수동으로 입력한 로또는 입력받은 숫자 그대로 로또를 생성한다.")
    void lottoManualMakeTest(String manualLottoNumber, List<Integer> expectedLottoNumbers) {
        LottoManualMake lottoAutoMake = new LottoManualMake(List.of(manualLottoNumber));
        List<Lotto> lottoManual = lottoAutoMake.makeLottos();

        assertThat(lottoManual.get(0).getLottoNumbers().getNumbers()).isEqualTo(expectedLottoNumbers);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,5,7,8,10,15})
    @DisplayName("자동 로또 갯수만큼 로또를 생성하고, 수동으로 입력한 로또는 입력받은 숫자 그대로 로또를 생성한다.")
    void lottoMakeTest(int autoLottoCount) {
        LottoAutoMake lottoAutoMake = new LottoAutoMake(new LottoCount(autoLottoCount));
        List<Lotto> lottoAuto = lottoAutoMake.makeAutoLottos();

        assertThat(lottoAuto.size()).isEqualTo(autoLottoCount);
    }
}
