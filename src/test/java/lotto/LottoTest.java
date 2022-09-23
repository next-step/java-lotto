package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {

    @DisplayName("로또는 6개의 번호를 가진다.")
    @Test
    void createLottos() {
        List<LottoNumber> numberLottoNumbers = List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));

        assertDoesNotThrow(() -> new Lotto(numberLottoNumbers));
    }

    @DisplayName("로또는 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void checkSize() {
        List<LottoNumber> numberLottoNumbers = List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5));

        assertThatThrownBy(() -> new Lotto(numberLottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 자동으로 생성한다.")
    @Test
    void createAuto() {

    }

    @DisplayName("로또 끼리 비교해 몇개가 일치하는지 알 수 있다.")
    @Test
    void equals() {
        Lotto lottoA = new Lotto(List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        Lotto lottoB = new Lotto(List.of(new LottoNumber(1),
                new LottoNumber(20),
                new LottoNumber(3),
                new LottoNumber(40),
                new LottoNumber(5),
                new LottoNumber(6)));

        assertThat(lottoA.matchCount(lottoB)).isEqualTo(4);
    }
}