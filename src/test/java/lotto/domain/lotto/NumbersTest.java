package lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class NumbersTest {
    @Test
    void 생성_테스트() {
        assertThatCode(() -> Numbers.create()).doesNotThrowAnyException();
    }

    @Test
    void 여섯자리_로또번호를_생성한다() {
        List<Integer> lottoNumbers = Numbers.create().createLottoNumbers();
        assertThat(lottoNumbers).size().isEqualTo(6);
    }

}