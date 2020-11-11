package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("로또 한장을 만듭니다.")
    void create(){
        Lotto lotto = new Lotto();
        assertThat(lotto.getLottoNumbers).has(6);
    }
}
