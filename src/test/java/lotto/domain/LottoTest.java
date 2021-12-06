package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 생성 테스트")
    @Test
    void createLotto() {
        Lotto actual = Lotto.from("2, 9, 13, 33 ,39, 45");

        assertThat(actual).isNotNull();
    }

    @DisplayName("로또 생성 테스트 - 로또는 6자리의 숫자만 가능하다")
    @Test
    void createLottoDuplicate() {
        assertThatThrownBy(() -> Lotto.from("2, 2, 13, 33 ,39, 45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 동등성 테스트")
    @Test
    void equalLotto() {
        String lottoText = "2, 9, 13, 33 ,39, 45";
        Lotto buyLotto = Lotto.from(lottoText);
        Lotto winLotto = Lotto.from(lottoText);

        assertThat(buyLotto).isEqualTo(winLotto);
    }

    @DisplayName("번호가 포함 되어 있는지 테스트")
    @Test
    void containLottoNumber() {
        Lotto lotto = Lotto.from("3, 9, 13, 33 ,39, 45");
        LottoNumber lottoNumber = new LottoNumber(3);

        assertThat(lotto.containLottoNumber(lottoNumber)).isTrue();
    }

    @DisplayName("두 개의 로또가 몇개의 번호가 맞는지 테스트")
    @Test
    void sameLottoNumberCountTest() {
        Lotto buyLotto = Lotto.from("2, 9, 13, 33 ,39, 45");
        Lotto winLotto = Lotto.from("2, 9, 14, 33 ,40, 45");

        long actual = buyLotto.sameLottoNumberCount(winLotto);
        long expected = 4;

        assertThat(actual).isEqualTo(expected);
    }

}
