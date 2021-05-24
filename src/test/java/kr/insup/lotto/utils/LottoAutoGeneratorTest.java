package kr.insup.lotto.utils;

import kr.insup.lotto.config.LottoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoGeneratorTest {

    @DisplayName("번호 6개 랜덤 생성")
    @Test
    void 번호_6개_랜덤_생성() {
        //given
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();

        //when
        List<Integer> lottoNumbers = lottoAutoGenerator.generateNumber();

        //then
        assertThat(lottoNumbers).hasSize(LottoConfig.LOTTO_COUNT);
    }
}
