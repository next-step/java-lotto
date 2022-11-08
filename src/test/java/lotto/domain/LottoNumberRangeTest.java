package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberRange;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoNumberRangeTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void createLotto() {
        Lotto lotto = LottoNumberRange.createLotto();
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        Assertions.assertThat(lottoNumbers).hasSize(Lotto.SELECT_SIZE);
    }
}
