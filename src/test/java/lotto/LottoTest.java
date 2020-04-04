package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void generateLottoTest() {
        Lotto.newAutomatic().getLottoNumbers();
    }

    @Test
    @DisplayName("로또번호 생성시 이미 있는 번호 테스트")
    void isNumberExistTest() {
        Lotto lotto = Lotto.newManual("1, 2, 3, 4, 5, 6");

        assertAll(
                () -> assertThat(lotto.isExistNumber(LottoNumber.newChooseNumber(1))).isTrue(),
                () -> assertThat(lotto.isExistNumber(LottoNumber.newChooseNumber(5))).isTrue(),
                () -> assertThat(lotto.isExistNumber(LottoNumber.newChooseNumber(8))).isFalse(),
                () -> assertThat(lotto.isExistNumber(LottoNumber.newChooseNumber(10))).isFalse()
        );
    }

    @Test
    @DisplayName("중복된 로또번호 테스트")
    void validateDuplicationNumbersTest() {
        assertThatThrownBy(
                () -> Lotto.newManual("1, 2, 3, 4, 5, 5")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또번호 맞춘 갯수 가져오기 테스트")
    void getMatchedCountTest() {
        Lotto winningLotto = Lotto.newManual("1, 2, 3, 4, 5, 6");
        Lotto lotto = Lotto.newManual("1, 2, 3, 4, 5, 45");

        assertThat(winningLotto.getMatchedCount(lotto)).isEqualTo(5);
    }

    @Test
    @DisplayName("getLottoNumbers 불변검사")
    void getLottoNumbersTest() {
        Lotto lo = Lotto.newAutomatic();
        lo.getLottoNumbers().add(LottoNumber.newChooseNumber(44));

        assertThat(lo.getLottoNumbers().size()).isEqualTo(6);
    }
}
