package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void init() {
        lotto = new Lotto(Arrays.asList(16, 26, 32, 35, 37, 39));
    }

    @Test
    public void createLottoTest() {
        assertThat(this.lotto.getLotto().size()).isEqualTo(6);
    }

}