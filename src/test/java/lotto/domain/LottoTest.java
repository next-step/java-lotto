package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    @Test
    @DisplayName("당첨 로또 확인하기 : 3개 일치")
    void match_3_nums_test() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5));

        long result = lotto.matchNumberCnt(
                new Lotto(Stream.of(3, 4, 5, 6, 7)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()))
        );

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨 로또 확인하기 : 0개 일치")
    void match_0_nums_test() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5));

        long result = lotto.matchNumberCnt(new Lotto(Stream.of(9, 10, 11, 6, 7)
                .map(LottoNumber::new)
                .collect(Collectors.toList())));

        assertThat(result).isZero();
    }
}
