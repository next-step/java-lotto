package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.model.Lotto;
import step2.model.LottoMake;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMakeTest {

    @ParameterizedTest
    @CsvSource(value = {"12000:12", "14000:14", "2000:2", "1000:1", "5000:5"}, delimiter = ':')
    @DisplayName("지불한 가격만큼 로또를 생성한다.")
    void lottoMakeTest(int lottoPayPrice, int expectedMakeCount) {
        LottoMake lottoMake = new LottoMake(lottoPayPrice);
        List<Lotto> lottos = lottoMake.makeLottos();

        assertThat(lottos.size()).isEqualTo(expectedMakeCount);
    }
}
