package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoGenerateTest {

    @Test
    @DisplayName("")
    void generate_사이즈_테스트() {
        LottoGenerate lottoGenerate = new LottoGenerate();
        List<Integer> lottoNumbers = lottoGenerate.generate();

        assertThat(lottoNumbers).hasSize(6);
    }

}