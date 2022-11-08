package lotto.domain;

import exception.CustomException;
import lotto.exception.LottoErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 객체로 로또를 생성하는 테스트")
    void fromLotto() {
        Lotto lotto = LottoNumberRange.createLotto();
        Lotto fromLotto = Lotto.from(lotto);
        assertThat(lotto).isEqualTo(fromLotto);
    }

    @Test
    @DisplayName("로또 번호 리스트로 로또를 생성하는 테스트")
    void fromLottoNumberList() {
        Lotto lotto = LottoNumberRange.createLotto();
        List<LottoNumber> lottoNumberList = lotto.getLottoNumbers();
        Lotto fromLotto = Lotto.from(lottoNumberList);
        assertThat(lotto).isEqualTo(fromLotto);
    }

    @Test
    @DisplayName("지정된 로또 크기보다 적게 입력한 경우 로또 생성에 실패한다")
    void lottoSizeFail() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumber.from(1));
        assertThatThrownBy(() -> Lotto.from(lottoNumbers))
                .isInstanceOf(CustomException.class)
                .hasMessage(LottoErrorCode.LOTTO_SIZE_BAD_REQUEST.getMessage());
    }

    @Test
    @DisplayName("중복된 숫자가 포함된 경우 테스트가 실패한다")
    void lottoOverlapFail() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(LottoNumber.from(1));
        }

        assertThatThrownBy(() ->
            Lotto.from(lottoNumbers))
                .isInstanceOf(CustomException.class)
                .hasMessage(LottoErrorCode.LOTTO_NUMBER_OVERLAP.getMessage());
    }

    @Test
    @DisplayName("전달받은 로또와 몇개가 일치하는지 계산한다")
    void containCount() {
        Lotto lotto = LottoNumberRange.createLotto();
        Lotto copyLotto = Lotto.from(lotto.getLottoNumbers());
        Long containCount = lotto.containCount(copyLotto);
        assertThat(containCount).isEqualTo(Lotto.SELECT_SIZE);
    }

    @Test
    @DisplayName("해당 숫자가 로또에 포함되어 있는지 확인한다")
    void contain() {
        Lotto lotto = StringLottoNumbers.toLotto("1, 2, 3, 4, 5, 6");
        LottoNumber lottoNumber = LottoNumber.from(6);
        assertThat(lotto.contain(lottoNumber)).isTrue();
    }
}