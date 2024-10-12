package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("getMatchingNumberCount 메서드에 null을 전달하면 0이 반환된다.")
    void getLottoMatchNumberInfoParameterIsNullTest() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getLottoMatchNumberInfo(null).getCount()).isZero();
    }

    @Test
    @DisplayName("getMatchingNumberCount 메서드가 일치하는 로또번호 개수를 반환한다.")
    void getLottoMatchNumberInfoTest() {
        Lotto lotto1 = new Lotto(Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6)));
        Lotto lotto2 = new Lotto(Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(14),
                LottoNumber.valueOf(15),
                LottoNumber.valueOf(16)));
        assertThat(lotto1.getLottoMatchNumberInfo(lotto2).getCount()).isEqualTo(3);
        assertThat(lotto1.getLottoMatchNumberInfo(lotto2).hasBonus()).isFalse();
    }

    @Test
    @DisplayName("getMatchingNumberCount 메서드가 보너스번호를 포함한 일치하는 로또번호 개수를 반환한다.")
    void getLottoMatchNumberInfoWithBonusTest() {
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        Lotto lotto1 = new Lotto(Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6)), bonusNumber);
        Lotto lotto2 = new Lotto(Set.of(LottoNumber.valueOf(7),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(14),
                LottoNumber.valueOf(15),
                LottoNumber.valueOf(16)));
        assertThat(lotto1.getLottoMatchNumberInfo(lotto2).getCount()).isEqualTo(3);
        assertThat(lotto1.getLottoMatchNumberInfo(lotto2).hasBonus()).isTrue();
    }

    @Test
    @DisplayName("Lotto 객체를 생성할 때 로또 번호가 6개가 아니면 예외가 발생한다.")
    void validateLottoNumberCountTest() {
        Set<LottoNumber> lottoNumbers = Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5));
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호의 개수가 일치하지 않습니다.");
    }

    @Test
    @DisplayName("보너스 번호를 포함하여 Lotto 객체가 정상 생성된다.")
    void initLottoWithBonusNumberTest() {
        Set<LottoNumber> lottoNumbers = Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6));
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        assertThat(new Lotto(lottoNumbers, bonusNumber)).isNotNull();
    }

    @Test
    @DisplayName("보너스 번호를 포함하여 Lotto 객체를 생성할 때 로또 번호가 7개가 아니면 예외가 발생한다.")
    void validateLottoCountWithBonusNumberTest() {
        Set<LottoNumber> lottoNumbers = Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5));
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        assertThatThrownBy(() -> new Lotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스번호를 포함한 로또번호가 개수가 일치하지 않습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    void validateDuplicateBonusNumber() {
        Set<LottoNumber> lottoNumbers = Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6));
        LottoNumber bonusNumber = LottoNumber.valueOf(6);
        assertThatThrownBy(() -> new Lotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 로또 번호와 중복될 수 없습니다.");
    }
}