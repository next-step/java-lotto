package domain.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LottoLineTest {

    @DisplayName("로또 한줄 생성 성공")
    @Test
    void create_lotto_line_success() {
        Random random = new Random();
        LottoLine lottoLine = LottoLine.create(random);

        System.out.println(lottoLine.getLine());
        assertThat(lottoLine).isNotNull();
        assertThat(lottoLine.getLottoNumbers()).hasSize(6);
    }

}
