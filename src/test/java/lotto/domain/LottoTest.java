package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7, 10})
    void validate_lotto_numbers_size(int size) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 생성")
    void create_lotto() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }
}
