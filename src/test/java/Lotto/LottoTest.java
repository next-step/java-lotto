package Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("로또 하나 생성")
    void make_lotto(){
        //given
        List<Integer> lottoNumber = List.of(1,2,3,45,35,63);
        final Lotto lotto = new Lotto(lottoNumber);

        assertThat(lotto.getLottoNumber().size()).isEqualTo(6);
        assertThat(lotto.getLottoNumber()).doesNotHaveDuplicates();
    }
}