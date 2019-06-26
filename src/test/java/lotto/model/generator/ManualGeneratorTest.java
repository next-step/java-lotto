package lotto.model.generator;

import lotto.exception.NumbersIsEmptyException;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static lotto.model.LottoTest.ofLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ManualGeneratorTest {

    @DisplayName("수동으로 로또를 생성한다")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,6",
            "1, 2, 3, 4, 5, 6"
    })
    void createManualLotto(String numberOfLotto) {
        LottoGenerator lottoGenerator = new ManualGenerator(Arrays.asList(numberOfLotto));

        List<Lotto> lottos = lottoGenerator.generator();

        assertThat(lottos).contains(ofLotto(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("수동으로 null일 시 생성에 실패한다")
    @ParameterizedTest
    @NullAndEmptySource
    void createManualLottoFail(List<String> numberOfLotto) {
        assertThatExceptionOfType(NumbersIsEmptyException.class)
                .isThrownBy(() -> new ManualGenerator(numberOfLotto));
    }
}