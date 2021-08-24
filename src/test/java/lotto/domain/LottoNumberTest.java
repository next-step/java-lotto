package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName("같은 번호는 같은 로또 번호다.")
    @Test
    void same() {
        assertThat(new LottoNumber(3)).isEqualTo(new LottoNumber(3));
    }

    @DisplayName("LottoNumber 리스트 정렬")
    @Test
    void sort(){
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(10));
        lottoNumbers.add(new LottoNumber(3));
        Collections.sort(lottoNumbers);
        assertThat(lottoNumbers.get(0).value()).isEqualTo(3);
        assertThat(lottoNumbers.get(1).value()).isEqualTo(10);
    }

}