package lotto.domain;

import lotto.generator.ManualNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    public void 보너스번호_당첨번호_중복확인() {
        Lotto winning = new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 5, 6"));
        LottoNumber bonus = LottoNumber.from(5);

        Optional<LottoNumber> any = winning.getLottoNumbers().stream()
                .filter(lottoNumber -> lottoNumber.equals(bonus))
                .findAny();

        assertThatThrownBy(() -> new WinningLotto(winning, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }


}