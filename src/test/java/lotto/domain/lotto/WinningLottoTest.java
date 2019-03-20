package lotto.domain.lotto;

import lotto.enums.Rank;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    public void 임의의_로또_생성() {
        Numbers numbers = new Numbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        ));
        Lotto winningLotto = new WinningLotto(numbers, new LottoNumber(10));

        assertThat(winningLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 임의의_로또_정렬_후_생성() {
        Numbers numbers = new Numbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(3),
            new LottoNumber(5),
            new LottoNumber(2),
            new LottoNumber(4),
            new LottoNumber(6)
        ));
        Lotto winningLotto = new WinningLotto(numbers, new LottoNumber(10));

        assertThat(winningLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 로또_숫자_매치_카운트_3개_일치() {
        Numbers numbers = new Numbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        ));
        BasicLotto lotto = new BasicLotto(numbers);

        numbers = new Numbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(7),
            new LottoNumber(8),
            new LottoNumber(9)
        ));
        WinningLotto winningLotto = new WinningLotto(numbers, new LottoNumber(10));

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void 로또_숫자_매치_카운트_6개_일치() {
        Numbers numbers = new Numbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        ));
        BasicLotto lotto = new BasicLotto(numbers);

        numbers = new Numbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        ));
        WinningLotto winningLotto = new WinningLotto(numbers, new LottoNumber(10));
        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 보너스볼_포함_2등_여부_확인() {
        Numbers numbers = new Numbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(10)
        ));
        BasicLotto lotto = new BasicLotto(numbers);

        numbers = new Numbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        ));
        WinningLotto winningLotto = new WinningLotto(numbers, new LottoNumber(10));
        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.SECOND);
    }
}
