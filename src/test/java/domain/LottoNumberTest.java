package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    private static final int LOTTO_MAX_RANGE = 45;
    private static final int LOTTO_MIN_RANGE = 1;

    @Test
    @DisplayName("로또범위가 1, 45사이에서 생성되는지 테스트")
    void 로또가_1_45_사이범위에서_생성되는지_테스트() {

        LottoNumber lottoNumber = new LottoNumber();

        List<Integer> lottoNumberRange = lottoNumber.getLottoNumbers();;

        assertThat(Collections.max(lottoNumberRange)).isLessThanOrEqualTo(LOTTO_MAX_RANGE);
        assertThat(Collections.min(lottoNumberRange)).isGreaterThanOrEqualTo(LOTTO_MIN_RANGE);
    }

}