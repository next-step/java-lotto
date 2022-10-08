package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또번호_서로다른_6개숫자() {
        List<Integer> lottoNumbers = new Lotto().getRandomNumbers();
        Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
        assertThat(lottoSet).hasSize(6);
    }


}
