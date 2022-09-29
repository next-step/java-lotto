package lotto.domain;

import lotto.domain.type.Match;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {

    @DisplayName("로또는 6개의 번호를 가진다.")
    @Test
    void createLotto() {
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

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(numberLottoNumbers));
    }

    @DisplayName("6개 번호를 가진 로또를 자동으로 생성한다.")
    @Test
    void createAuto() {
        List<LottoNumber> lottoNumbers = Lotto.create().lottoNumbers();

        assertThat(lottoNumbers).hasSize(6);
    }

    @DisplayName("로또를 생성하면 번호는 정렬되어있다.")
    @Test
    void sort() {
        Lotto lotto = new Lotto(List.of(new LottoNumber(20),
                new LottoNumber(10),
                new LottoNumber(1),
                new LottoNumber(30),
                new LottoNumber(5),
                new LottoNumber(40)));

        List<LottoNumber> expected = List.of(new LottoNumber(1),
                new LottoNumber(5),
                new LottoNumber(10),
                new LottoNumber(20),
                new LottoNumber(30),
                new LottoNumber(40));
        assertThat(lotto.lottoNumbers()).isEqualTo(expected);
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

        Lotto winLotto = new Lotto(List.of(new LottoNumber(1),
                new LottoNumber(20),
                new LottoNumber(3),
                new LottoNumber(40),
                new LottoNumber(5),
                new LottoNumber(6)));

        Match type = lottoA.rank(winLotto);
        assertThat(type.count()).isEqualTo(Match.FOUR.count());
    }
}