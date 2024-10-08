package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 옳바른_로또_생성() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::generateByValue)
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto).isNotNull();
    }

    @Test
    void 로또_생성시_6개_검증() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 6)
                .map(LottoNumber::generateByValue)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_생성시_중복검증() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 3, 3, 6)
                .map(LottoNumber::generateByValue)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}