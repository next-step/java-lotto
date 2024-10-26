package lotto;

import lotto.model.LottoNumber;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningLottoTest {

    WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

    List<LottoNumber> boughtLottoNumbers = List.of(1, 3, 5, 7, 9, 11).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    @Test
    public void 구매한_로또_당첨_개수_확인() {
        assertThat(winningLotto.countMatchNumber(boughtLottoNumbers)).isEqualTo(3);
    }

    @Test
    public void 보너스번호가_구매한_로또에_포함되는지_확인() {
        assertThat(winningLotto.checkContainsBonusNumber(boughtLottoNumbers)).isTrue();
    }

    @Test
    public void 당첨번호와_보너스번호_중복되는지_확인() {
        assertThatThrownBy(() -> WinningLotto.isValidBonusNumber("1, 2, 3, 4, 5, 6", 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지난 주 당첨 번호와 보너스 볼이 중복되었습니다.");
    }

}
