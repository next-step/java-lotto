package lotto.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGeneratorTest {

    @Test
    @DisplayName("로또 자동 생성기는 로또를 6자리 생성한다.")
    void 자동_로또_생성_6자리() {
        // given
        LottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        // when
        List<LottoNumber> generateLotto = autoLottoGenerator.generate();
        // then
        assertThat(generateLotto.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 자동 생성기는 매번 실행 시,새로운 로또를 생성한다.")
    void 매번_자동_로또_생성() {
        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        assertThat(lottoGenerator.generate()).isNotEqualTo(lottoGenerator.generate());
    }

}
