package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningLottoTest {
    @Test
    void WinningLotto_당첨로또_생성() {
        WinningLotto winningLotto = new WinningLotto(Lotto.create(new int[]{1, 2, 3, 4, 5, 6}), 7);
        assertThat(winningLotto).isEqualTo(new WinningLotto(new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6))), new LottoNumber(7)));
    }

    @ParameterizedTest
    @NullSource
    void WinningLotto_당첨로또가_null_인_경우(Lotto winningLotto) {
        assertThatThrownBy(() -> new WinningLotto(winningLotto, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    void WinningLotto_보너스_번호가_null_인_경우(LottoNumber bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(Lotto.create(new int[]{1, 2, 3, 4, 5, 6}), bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void WinningLotto_보너스_번호가_당첨로또에_포함된_경우() {
        assertThatThrownBy(() -> new WinningLotto(Lotto.create(new int[]{1, 2, 3, 4, 5, 6}), 6)).isInstanceOf(IllegalArgumentException.class);
    }
}
