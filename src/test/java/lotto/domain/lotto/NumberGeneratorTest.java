package lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class NumberGeneratorTest {

    @Test
    void 생성_테스트() {
        assertThatCode(() -> NumberGenerator.create()).doesNotThrowAnyException();
    }

    @Test
    void 여섯자리_랜덤번호를_생성한다() {
        NumberGenerator number = NumberGenerator.create();
        List<LottoNumber> lottoNumber = number.createLottoNumbers();
        assertThat(lottoNumber).size().isEqualTo(6);
    }
}
