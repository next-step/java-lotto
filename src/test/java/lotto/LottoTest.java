package lotto;

import exception.CustomException;
import lotto.exception.LottoErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void generate() {
        Lotto lotto = Lotto.generate();
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        assertThat(lottoNumbers).hasSize(Lotto.SELECT_SIZE);
    }

    @Test
    @DisplayName("로또 객체로 로또를 생성하는 테스트")
    void fromLotto() {
        Lotto lotto = Lotto.generate();
        Lotto fromLotto = Lotto.from(lotto);
        assertThat(lotto).isEqualTo(fromLotto);
    }

    @Test
    @DisplayName("로또 번호 리스트로 로또를 생성하는 테스트")
    void fromLottoNumberList() {
        Lotto lotto = Lotto.generate();
        List<LottoNumber> lottoNumberList = lotto.getLottoNumbers();
        Lotto fromLotto = Lotto.from(lottoNumberList);
        assertThat(lotto).isEqualTo(fromLotto);
    }

    @Test
    @DisplayName("지정된 로또 크기보다 적게 입력한 경우 로또 생성에 실패한다")
    void lottoSizeFail() {
        String[] stringLottoNumbers = {"1", "2", "3"};
        List<LottoNumber> lottoNumbers = LottoNumber.from(stringLottoNumbers);
        assertThatThrownBy(() -> Lotto.from(lottoNumbers))
                .isInstanceOf(CustomException.class)
                .hasMessage(LottoErrorCode.LOTTO_SIZE_BAD_REQUEST.getMessage());
    }

    @Test
    @DisplayName("중복된 숫자가 포함된 경우 테스트가 실패한다")
    void lottoOverlapFail() {
        assertThatThrownBy(() ->
            Lotto.from("1, 2, 3, 3, 4, 5"))
                .isInstanceOf(CustomException.class)
                .hasMessage(LottoErrorCode.LOTTO_NUMBER_OVERLAP.getMessage());
    }
}