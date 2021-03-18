package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
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
                Arguments.of(
                        new RequestWinningNumber("1,2,3,4,5,6"),
                        LottoMatch.RANK_FIRST,
                        new LottoNumber(16)
                ),
                Arguments.of(
                        new RequestWinningNumber("4,5,6,7,8,9"),
                        LottoMatch.RANK_FOURTH,
                        new LottoNumber(16)
                ),
                Arguments.of(
                        new RequestWinningNumber("1,2,3,4,5,16"),
                        LottoMatch.RANK_BONUS,
                        new LottoNumber(6)
                )
        );
    }

    @ParameterizedTest(name = "로또 지난주 당첨 숫자 {0} 중에 맞춘 숫자 {1} 개 및 보너스 숫자 {2} 확인 ")
    @MethodSource(value = "expectedEntry")
    void match_로또_번호_생성_및_숫자매칭(RequestWinningNumber given, LottoMatch expected, LottoNumber bonusNumber) {
        // when
        LottoMatch match = lotto.match(given, bonusNumber);
        // then
        assertThat(match).isEqualTo(expected);
    }

    @ParameterizedTest(name = "지난 당첨번호 {0} : {2} 중 로또 번호 {1} 개 매칭, 당첨금 확인 ")
    @MethodSource(value = "expectedEntry")
    void winningReward_당첨_금액_확인(RequestWinningNumber given, LottoMatch expected, LottoNumber bonusNumber) {
        // when
        long reward = lotto.winningReward(given, bonusNumber);
        // then
        assertThat(reward).isEqualTo(expected.getWinningReward());
    }
}
