package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    private LottoNumber lottoNumber = LottoNumber.newInstance(5);
    private LottoTicket winLottoTicket = LottoTicketFactory.createManualLottoTicket("1, 2, 3, 4, 5, 6");

    @DisplayName("로또 번호 1 ~ 45 범위에 맞지 않으면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = { -1, 0, 46 })
    void canNotCreateLottoNumberIfNumberOutOfRange(int number) {
        assertThatThrownBy(() -> LottoNumber.newInstance(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 생성할 수 있다.")
    @Test
    void canCreateLottoNumber() {
        assertThat(this.lottoNumber).isInstanceOf(LottoNumber.class);
    }

    @DisplayName("당첨 번호가 존재하지 않으면 보너스 번호를 생성할 수 없다.")
    @Test
    void canNotCreateBonusNumberIfWinLottoTicketIsNull() {
        assertThatThrownBy(() -> LottoNumber.newBonusNumber(1, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있으면 생성할 수 없다.")
    @Test
    void canNotCreateBonusNumberIfNumberIncludeWinLottoNumber() {
        assertThatThrownBy(() -> LottoNumber.newBonusNumber(1, this.winLottoTicket))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 생성할 수 있다.")
    @Test
    void canCreateBonusNumber() {
        assertThat(LottoNumber.newBonusNumber(7, this.winLottoTicket)).isInstanceOf(LottoNumber.class);
    }

    @DisplayName("로또 번호를 얻을 수 있다.")
    @Test
    void canGetLottoNumber() {
        assertThat(this.lottoNumber.getLottoNumber()).isEqualTo(5);
    }

    @DisplayName("로또 번호를 문자열로 변환할 수 있다.")
    @Test
    void canToString() {
        assertThat(this.lottoNumber.toString()).isEqualTo("5");
    }

    @DisplayName("로또 번호가 같으면 동일한 객체이다.")
    @Test
    void canSameLottoNumberIfNumberSame() {
        LottoNumber lottoNumber = LottoNumber.newInstance(this.lottoNumber.getLottoNumber());

        assertThat(this.lottoNumber.getLottoNumber()).isEqualTo(lottoNumber.getLottoNumber());
        assertThat(this.lottoNumber).isEqualTo(lottoNumber);
        assertThat(this.lottoNumber.hashCode()).isEqualTo(lottoNumber.hashCode());
    }

    @DisplayName("로또 번호 내부 값으로 비교할 수 있다.")
    @Test
    void canCompareToLottoNumber() {
        LottoNumber otherLottoNumber = LottoNumber.newInstance(6);
        assertThat(this.lottoNumber.compareTo(otherLottoNumber)).isLessThan(0);

        otherLottoNumber = LottoNumber.newInstance(5);
        assertThat(this.lottoNumber.compareTo(otherLottoNumber)).isZero();

        otherLottoNumber = LottoNumber.newInstance(4);
        assertThat(this.lottoNumber.compareTo(otherLottoNumber)).isGreaterThan(0);
    }
}
