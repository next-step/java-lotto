package lotto.model;

import lotto.model.enumeration.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    public void 로또_일치_1등_검증() {
        WinningLotto winningLotto = new WinningLotto(createLottoNumber(1, 2, 4, 24, 25, 45), new LottoNumber(43));

        Lotto lotto = new Lotto(createLottoNumber(1, 2, 4, 24, 25, 45));

        Rank result = winningLotto.match(lotto);

        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 로또_일치_2등_검증() {
        WinningLotto winningLotto = new WinningLotto(createLottoNumber(1, 2, 4, 24, 25, 45), new LottoNumber(43));

        Lotto lotto = new Lotto(createLottoNumber(1, 2, 4, 24, 25, 43));

        Rank result = winningLotto.match(lotto);

        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 로또_일치_없음_검증() {
        WinningLotto winningLotto = new WinningLotto(createLottoNumber(1, 2, 4, 24, 25, 45), new LottoNumber(43));

        Lotto lotto = new Lotto(createLottoNumber(3, 5, 7, 21, 22, 40));

        Rank result = winningLotto.match(lotto);

        assertThat(result).isEqualTo(Rank.MISS);
    }

    private List<LottoNumber> createLottoNumber(int... number) {
        return Arrays.stream(number)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}