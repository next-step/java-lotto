package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @Test
    @DisplayName("1에서 45 사이의 로또 번호 6자리를 생성한다")
    void shouldDrawLottoNumbers() {
        List<LottoNumber> lottoNumbers = LottoMachine.draw();

        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(lottoNumbers).allMatch(this::inRange);
    }

    private boolean inRange(LottoNumber lottoNumber) {
        return lottoNumber.getValue() >= 0 && lottoNumber.getValue() <= 45;
    }
}