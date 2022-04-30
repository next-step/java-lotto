package lotto.domain;

import lotto.exception.InvalidLottoNumberCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또를 생성할때 6개의 로또 넘버가 없으면 InvalidLottoNumberCount 를 반환한다.")
    void InvalidNumberException() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));

        assertThatThrownBy(() -> new Lotto(lottoNumbers)).isInstanceOf(InvalidLottoNumberCount.class);
    }
}