package step2.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    @DisplayName("로또 1장 생성기")
    public void create() {
        LottoNumbers lottoNumbers = new LottoNumbers(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

        assertThat(new Lotto()).isEqualTo(new Lotto());
    }
}
