package lotto.domain;

import lotto.domain.type.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.fixture.Fixture.getLottoNumbersFixture;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {

    @DisplayName("로또는 6개의 번호를 가진다.")
    @Test
    void createLotto() {
        List<LottoNumber> numberLottoNumbers = getLottoNumbersFixture(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> new ManualLotto(numberLottoNumbers));
    }

    @DisplayName("로또는 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void checkSize() {
        List<LottoNumber> numberLottoNumbers = List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5));

        assertThatIllegalArgumentException().isThrownBy(() -> ManualLotto.create(numberLottoNumbers));
    }

    @DisplayName("로또를 생성하면 번호는 정렬되어있다.")
    @Test
    void sort() {
        Lotto lotto = new ManualLotto(getLottoNumbersFixture(20, 1, 30, 5, 40, 10));

        List<LottoNumber> expected = getLottoNumbersFixture(1, 5, 10, 20, 30, 40);

        assertThat(lotto.lottoNumbers()).isEqualTo(expected);
    }

    @DisplayName("로또 끼리 비교해 몇개가 일치하는지 알 수 있다.")
    @Test
    void matchCount() {
        Lotto lottoA = new ManualLotto(getLottoNumbersFixture(1, 2, 3, 4, 5, 6));
        Lotto winLotto = new ManualLotto(getLottoNumbersFixture(1, 20, 3, 40, 5, 6));
        LottoNumber bonusNumber = LottoNumber.of(45);

        Rank type = lottoA.rank(winLotto, bonusNumber);

        assertThat(type).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("번호가 같은 경우 동일한 로또로 판별한다.")
    @Test
    void equals() {
        Lotto lottoA = new ManualLotto(getLottoNumbersFixture(1, 2, 3, 4, 5, 6));
        Lotto lottoB = new AutoLotto(getLottoNumbersFixture(1, 2, 3, 4, 5, 6));

        assertThat(lottoA).isEqualTo(lottoB);
    }

    @DisplayName("보너스 번호인지 확인이 가능하다.")
    @Test
    void checkBonus() {
        Lotto lottoA = new ManualLotto(getLottoNumbersFixture(1, 2, 3, 4, 5, 6));
        Lotto winLotto = new ManualLotto(getLottoNumbersFixture(1, 2, 3, 4, 5, 45));
        LottoNumber bonusNumber = LottoNumber.of(6);

        Rank type = lottoA.rank(winLotto, bonusNumber);

        assertThat(type).isEqualTo(Rank.BONUS);
    }

    @DisplayName("로또 번호는 중복될 수 없다.")
    @Test
    void duplicate() {
        assertThatThrownBy(() -> {
            new ManualLotto(getLottoNumbersFixture(1, 1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}