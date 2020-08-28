package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShuffleMachineTest {

    @DisplayName("여섯개의 로또번호를 랜덤으로 받는다.")
    @Test
    void shuffle() {
        Set<LottoNumber> lottoNumbers = LottoShuffleMachine.getSixNumbers();

        //then
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
