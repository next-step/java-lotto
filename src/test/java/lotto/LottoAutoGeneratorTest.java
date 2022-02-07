package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.LottoAutoGenerator;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

class LottoAutoGeneratorTest {

    @Test
    void 로또번호_랜덤생성() {
        List<LottoNumber> lottoNum = LottoAutoGenerator.getInstance().generateLotto();

        assertThat(lottoNum.size()).isEqualTo(6);
        Set<LottoNumber> duplicate = new HashSet<>(lottoNum);
        assertThat(lottoNum.size()).isEqualTo(duplicate.size());
    }
}
