package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGenerateStrategyTest {
    
    @Test
    @DisplayName("6 개의 로또 번호를 생성한다.")
    void generateSixLottoNumbers() {
        Set<LottoNumber> lottoNumbers = new RandomGenerateStrategy().generateLottoNumbers();
        assertThat(lottoNumbers).hasSize(6);
    }

}