package study.ascii92der.lotto.step3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    void lottoNumberCountTest() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.generateNumber().size()).isEqualTo(6);
    }
}
