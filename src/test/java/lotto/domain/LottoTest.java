package lotto.domain;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또는 6개의 로또 숫자를 갖는다")
    void lottoSizeTest() {
        // given
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        // when
        Lotto lotto = new Lotto(lottoNumbers);
        // then
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("6개가 아닌 로또 숫자를 갖으면 InvalidLottoException 발생")
    void throwInvalidLottoExceptionTest() {
        // given
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2)
        );
        // when, then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(InvalidLottoException.class);
    }

}
