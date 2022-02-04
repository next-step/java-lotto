package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;

class LottoAutoGeneratorTest {

    @Test
    void 로또번호_랜덤생성(){
        LottoNumbers lottoNum = LottoAutoGenerator.getInstance().generateLotto();

        assertThat(lottoNum.size()).isEqualTo(6);
        Set<LottoNumber> duplicate = new HashSet<>(lottoNum.getNumbers());
        assertThat(lottoNum.size()).isEqualTo(duplicate.size());
    }
}