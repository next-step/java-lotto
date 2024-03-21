package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGeneratorTest {

    @DisplayName("자동 로또 발급기는 중복되지 않는 6개의 숫자를 포함한 로또를 발급한다.")
    @Test
    void ticket() {
        final Lotto lotto = AutoLottoGenerator.ticket();
        final List<LottoNumber> lottoNumbers = lotto.numbers();

        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(new HashSet<>(lottoNumbers).size()).isEqualTo(6);
    }

}
