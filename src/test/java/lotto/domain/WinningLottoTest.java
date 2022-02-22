package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 해당_로또가_몇_등인지_계산할_수_있다() {
        final List<LottoNumber> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        final LottoNumber bonusBall = new LottoNumber(8);

        final WinningLotto winningLotto = new WinningLotto(Lotto.ManualLotto(winningNumber), bonusBall);

        final List<LottoNumber> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 7).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        final Lotto lotto = Lotto.ManualLotto(lottoNumbers);

        assertThat(winningLotto.matchLotto(lotto)).isEqualTo(Ranking.THIRD);
    }

}
