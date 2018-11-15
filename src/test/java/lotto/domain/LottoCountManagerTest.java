package lotto.domain;

import lotto.exceptions.ValidationException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCountManagerTest {

    @Test(expected = ValidationException.class)
    public void name() {
        assertThat(new LottoCountManager(14000, 15).getAutoLottoCount()).isEqualTo(-1);
    }
}