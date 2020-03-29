package lotto.domain;

import lotto.common.LottoStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("보너스 번호를 생성할 수 있다")
    @Test
    public void createBonusNumberTest() {
        List<LottoNumber> lottoNumbers = LottoStub.getLottoNubers(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = LottoStub.getLottoTicket(lottoNumbers);

        BonusNumber one = new BonusNumber(lottoTicket, 7);
        BonusNumber another = new BonusNumber(lottoTicket, 7);

        assertThat(one).isEqualTo(another);
    }

    @DisplayName("보너스 번호만 같아도 같은 객체로 판단한다")
    @Test
    public void bonusNumberEqualsTest() {
        List<LottoNumber> fistLottoNumbers = LottoStub.getLottoNubers(1, 2, 3, 4, 5, 6);
        List<LottoNumber> secondLottoNumbers = LottoStub.getLottoNubers(8, 9, 10, 11, 12, 13);
        LottoTicket firstTicket = LottoStub.getLottoTicket(fistLottoNumbers);
        LottoTicket secondTicket = LottoStub.getLottoTicket(secondLottoNumbers);

        BonusNumber one = new BonusNumber(firstTicket, 7);
        BonusNumber another = new BonusNumber(secondTicket, 7);

        assertThat(one).isEqualTo(another);
    }

    @DisplayName("보너스 번호는 1 ~ 45 사이의 수를 가질 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void bonusNumberRangeTest(int bonusNumber) {
        List<LottoNumber> lottoNumbers = LottoStub.getLottoNubers(1, 2, 3, 4, 5, 6);
        LottoTicket firstTicket = LottoStub.getLottoTicket(lottoNumbers);

        assertThatThrownBy(() -> new BonusNumber(firstTicket, bonusNumber))
                .isInstanceOf(BonusNumberRangeException.class)
                .hasMessageContaining("보너스 번호 1~45 사이의 수만 가능합니다.");
    }

    @DisplayName("보너스 번호는 기존 당첨번호와 중복될 수 없다")
    @Test
    public void doesntDuplicateBonusNumber() {
        List<LottoNumber> lottoNumbers = LottoStub.getLottoNubers(1, 2, 3, 4, 5, 6);
        LottoTicket firstTicket = LottoStub.getLottoTicket(lottoNumbers);

        assertThatThrownBy(() -> new BonusNumber(firstTicket, 6))
                .isInstanceOf(BonusNumberDuplicateException.class)
                .hasMessageContaining("보너스 번호는 당첨번호와 중복될 수 없습니다.");
    }

}
