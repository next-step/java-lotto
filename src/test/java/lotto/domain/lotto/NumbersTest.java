package lotto.domain.lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NumbersTest {

    @Test
    public void 넘버_포함_여부() {
        List<LottoNumber> list = Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        );
        Numbers numbers = new Numbers(list);

        assertTrue(numbers.contains(new LottoNumber(3)));
    }

    @Test
    public void 넘버_포함_수_카운트() {
        List<LottoNumber> list = Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        );
        Numbers numbers = new Numbers(list);
        list = Arrays.asList(new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6),
            new LottoNumber(7),
            new LottoNumber(8),
            new LottoNumber(9)
        );
        Numbers taegetNumbers = new Numbers(list);

        assertThat(numbers.matchCount(taegetNumbers)).isEqualTo(3);
    }
}
