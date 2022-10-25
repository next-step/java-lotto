package lotto.model;

import lotto.exception.InvalidLottoSizeException;
import lotto.model.enumeration.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    public void 로또_생성_숫자_개수_검증() {
        assertThatThrownBy(() -> new Lotto(createLottoNumber(1, 13, 15, 17, 20, 42, 44)))
                .isInstanceOf(InvalidLottoSizeException.class);
    }

    @Test
    public void 로또_번호_일치_검증() {
        Lotto lottoNumbers = new Lotto(createLottoNumber(1, 13, 15, 17, 20, 45));

        WinningLotto winningLotto = new WinningLotto(createLottoNumber(1, 13, 15, 17, 33, 45), new LottoNumber(40));

        Rank result = winningLotto.match(lottoNumbers);

        assertThat(result).isEqualTo(Rank.THIRD);
    }

    @Test
    public void 로또_번호_일치_보너스_볼_포함_검증() {
        Lotto lottoNumbers = new Lotto(createLottoNumber(1, 13, 15, 17, 20, 45));

        WinningLotto winningLotto = new WinningLotto(createLottoNumber(1, 13, 15, 17, 33, 45), new LottoNumber(20));

        Rank result = winningLotto.match(lottoNumbers);

        assertThat(result).isEqualTo(Rank.SECOND);
    }

    private List<LottoNumber> createLottoNumber(int... number) {
        return Arrays.stream(number)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}