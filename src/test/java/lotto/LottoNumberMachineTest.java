package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberMachineTest {

    LottoNumberMachine lottoNumberMachine = new LottoNumberMachine();

    @Test
    void lottoNumbers_return_numbers_size_is_6_and_sorted() {
        // when
        List<Number> lottoNumbers = lottoNumberMachine.lottoNumbers();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(lottoNumbers.get(0).compareTo(lottoNumbers.get(1))).isEqualTo(-1);
        assertThat(lottoNumbers.get(1).compareTo(lottoNumbers.get(2))).isEqualTo(-1);
        assertThat(lottoNumbers.get(2).compareTo(lottoNumbers.get(3))).isEqualTo(-1);
        assertThat(lottoNumbers.get(3).compareTo(lottoNumbers.get(4))).isEqualTo(-1);
        assertThat(lottoNumbers.get(4).compareTo(lottoNumbers.get(5))).isEqualTo(-1);
        assertThat(lottoNumbers.get(5).compareTo(lottoNumbers.get(0))).isEqualTo(1);
    }

}
