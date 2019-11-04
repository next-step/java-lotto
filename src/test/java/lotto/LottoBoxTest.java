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

    @Test
    @DisplayName("매번 다른 번호가 생성되는지 확인한다.")
    void isRandomNumbers() {
        Lotto firstLotto = new Lotto(LottoBox.generateNumbers());
        Lotto second = new Lotto(LottoBox.generateNumbers());
        assertThat(firstLotto).isNotEqualTo(second);
    }
}
