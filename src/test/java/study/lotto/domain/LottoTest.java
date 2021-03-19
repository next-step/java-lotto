package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.lotto.domain.type.LottoMatch;
import study.lotto.view.dto.RequestWinningNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        List<LottoNumber> collect = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        lotto = new Lotto(collect);
    }

    @DisplayName("로또 생성 및 match 된 숫자 테스트")
    @Test
    void match_로또_번호_생성_및_숫자매칭() {
        // given
        List<LottoNumber> collect = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Lotto given = new Lotto(collect);
        // when
        long match = lotto.match(given);
        // then
        assertThat(match).isEqualTo(6);
    }
}
