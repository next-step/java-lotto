package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRandomNumberUtilTest {

    @Test
    @DisplayName("자동 로또 번호 생성")
    public void lottoNumber() throws Exception {
        List<Integer> lottoNumbers = LottoRandomNumberUtil.lottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}