package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("생성 테스트")
    void balls_ctor_test() {
        List<LottoNumber> lottoNumbers = List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        );
        assertThatNoException().isThrownBy(() -> new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("로또 안에 중복되는 숫자가 있으면 예외가 발생한다.")
    void lottoNumbers_reduplication_throw_exception() {
        List<LottoNumber> lottoNumbers = List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(5)
        );

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
            .isInstanceOf(LottoException.class)
            .hasMessage("로또 번호는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    void lottoNumbers_not_6_throw_exception() {
        List<LottoNumber> lottoNumbers = List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5)
        );

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
            .isInstanceOf(LottoException.class)
            .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 개수를 알려준다.")
    void lottoNumbers_agreementCount_winningNumber_test() {
        List<LottoNumber> inputLottoNumbers = List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        );
        List<LottoNumber> winnerLottoNumbers = List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(8)
        );

        Lotto person = new Lotto(inputLottoNumbers);
        Lotto winningNumber = new Lotto(winnerLottoNumbers);

        int count = person.winningNumberCount(winningNumber);

        assertThat(count).isEqualTo(5);
    }





}
