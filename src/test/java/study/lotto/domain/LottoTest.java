package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
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


    private static Stream<Arguments> expectedEntry() {
        return Stream.of(
                Arguments.of(new RequestWinningNumber("1,2,3,4,5,6"), LottoMatch.RANK_FIRST),
                Arguments.of(new RequestWinningNumber("4,5,6,7,8,9"), LottoMatch.RANK_FOURTH)
        );
    }

    @ParameterizedTest(name = "로또 지난주 당첨 숫자{0} 중에 몇 개 맞췄는지 확인 {1}")
    @MethodSource(value = "expectedEntry")
    void match_로또_번호_생성_및_숫자매칭(RequestWinningNumber given, LottoMatch expected) {
        // when
        LottoMatch match = lotto.match(given);
        // then
        assertThat(match).isEqualTo(expected);
    }

    @ParameterizedTest(name = "로또 번호 {1} 개 매칭되어 당첨금 확인 ")
    @MethodSource(value = "expectedEntry")
    void winningReward_당첨_금액_확인(RequestWinningNumber given, LottoMatch expected) {
        // when
        long reward = lotto.winningReward(given);
        // then
        assertThat(reward).isEqualTo(expected.getWinningReward());
    }
}
