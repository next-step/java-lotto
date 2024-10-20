package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 발급하였을 때 총 6개 숫자를 반환하는지 확인")
    void getLottoNumbers() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumbers = lotto.generateLotto();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

}
