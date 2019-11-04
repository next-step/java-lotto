package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBoxTest {
    @Test
    @DisplayName("6개의 숫자를 생성하는지 확인한다.")
    void generateNumbers() {
        List<LottoNumber> lottoNumbers = LottoBox.generateNumbers();
        assertThat(lottoNumbers).hasSize(6);
    }
}
