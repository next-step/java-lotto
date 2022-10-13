package lotto.model;

import lotto.exception.InvalidLottoSizeException;
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
        List<LottoNumber> lastWinLotto = createLottoNumber(1, 13, 15, 17, 33, 45);

        double result = lottoNumbers.matchCount(new Lotto(lastWinLotto));

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 보너스_볼_일치_반환값_검증() {
        Lotto lottoNumbers = new Lotto(createLottoNumber(1, 13, 15, 17, 20, 45));

        double result = lottoNumbers.matchBonusBallCount(1);

        assertThat(result).isEqualTo(0.5);
    }

    @Test
    public void 보너스_볼_불일치_반환값_검증() {
        Lotto lottoNumbers = new Lotto(createLottoNumber(1, 13, 15, 17, 20, 45));

        double result = lottoNumbers.matchBonusBallCount(12);

        assertThat(result).isEqualTo(0);
    }

    private List<LottoNumber> createLottoNumber(int... number) {
        return Arrays.stream(number)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}