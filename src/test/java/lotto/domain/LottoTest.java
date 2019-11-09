package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 생성() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 로또번호_개수_부족하거나_많을때(final String input) {
        String[] inputSplit = input.split(",");
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : inputSplit) {
            lottoNumbers.add(LottoNumber.of(Integer.parseInt(number)));
        }

        assertThatThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
