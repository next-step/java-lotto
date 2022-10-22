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
        List<LottoNumber> lottoNumbers = lotto.getLotto();
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
        List<LottoNumber> lottoNumberList = lotto.getLotto();
        Lotto fromLotto = Lotto.from(lottoNumberList);
        assertThat(lotto).isEqualTo(fromLotto);
    }

    @Test
    void lottoSizeFail() {
        String[] stringLottoNumbers = {"1", "2", "3"};
        List<LottoNumber> lottoNumbers = LottoNumber.from(stringLottoNumbers);
        assertThatThrownBy(() -> Lotto.from(lottoNumbers))
                .isInstanceOf(CustomException.class)
                .hasMessage(LottoErrorCode.LOTTO_SIZE_BAD_REQUEST.getMessage());
    }
}