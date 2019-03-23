import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;


public class LottoTest {
    private Lotto lotto;

    @Before
    public void setUp() throws Exception {
        lotto = new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    @Test
    public void 당첨번호_매칭수_일치() {
        assertThat(lotto.getMatchNumber(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12).stream().map(LottoNumber::new).collect(Collectors.toList())))).isEqualTo(0);
        assertThat(lotto.getMatchNumber(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7).stream().map(LottoNumber::new).collect(Collectors.toList())))).isEqualTo(5);
        assertThat(lotto.getMatchNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(Collectors.toList())))).isEqualTo(6);
    }

    @Test
    public void 보너스번호_매칭_일치() {
        assertFalse(lotto.isMatchBonusNumber(new LottoNumber(7)));
        assertThat(lotto.isMatchBonusNumber(new LottoNumber(6)));
    }
}