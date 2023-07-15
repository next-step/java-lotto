package view;

import static org.assertj.core.api.Assertions.assertThat;

import domain.LottoFormatter;
import domain.LottoNumber;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultLottoFormatterTest {

    @Test
    @DisplayName("로또 번호를 받아 기본 포맷 문자열로 변환한다.")
    void format() {
        /* given */
        final LottoFormatter lottoFormatter = new DefaultLottoFormatter();
        final Set<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::new)
            .collect(Collectors.toUnmodifiableSet());

        /* when */
        final String result = lottoFormatter.format(lottoNumbers);

        /* then */
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
