package dev.dahye.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberExtractorTest {
    @Test
    @DisplayName("로또 생성 시 6개의 숫자로 이루어진 List<LottoNumber> 객체를 반환한다.")
    void create_lotto_number() {
        assertThat(LottoNumberExtractor.create().size()).isEqualTo(LottoNumberExtractor.LOTTO_SIZE);
    }

    @Test
    @DisplayName("수동 로또 생성 시 List<LottoNumber> 재활용한 객체를 반환한다.")
    void create_manual_lotto_number() {
        assertThat(LottoNumberExtractor.convert(Arrays.asList(1, 2, 3, 4, 5, 6)).size())
                .isEqualTo(LottoNumberExtractor.LOTTO_SIZE);
    }
}