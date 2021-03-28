package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 한 세트를 생성한다")
    @Test
    void createLottoTest() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
        Lotto createdLotto = new Lotto(lottoNumberList);
        assertThat(createdLotto.numberOfSize()).isEqualTo(6);
    }

    @DisplayName("로또 한 세트는 6개의 숫자로 이뤄진다. 이 외에는 예외를 발생시킨다")
    @Test
    void createLottoExceptionTest() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
        assertThatThrownBy(() -> new Lotto(lottoNumberList)).isInstanceOf(IllegalArgumentException.class);
        lottoNumberList.add(new LottoNumber(8));
        lottoNumberList.add(new LottoNumber(9));
        assertThatThrownBy(() -> new Lotto(lottoNumberList)).isInstanceOf(IllegalArgumentException.class);
    }
}
