package step2.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {
    @Test
    @DisplayName("로또 1장 생성기")
    public void create() {
        List<Integer> lottoNumbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));

        assertThat(new LottoFactory(lottoNumbers)).isEqualTo(new LottoFactory(lottoNumbers));
    }
}
