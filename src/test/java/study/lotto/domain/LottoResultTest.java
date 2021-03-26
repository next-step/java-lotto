package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.lotto.domain.type.LottoMatch;
import study.lotto.domain.type.ProfitMessage;
import study.lotto.service.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private List<Lotto> lottoList;

    @BeforeEach
    void setUp() {
        List<LottoNumber> collect = IntStream.range(1, 7)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
        List<LottoNumber> collect1 = IntStream.range(7, 13)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
        lottoList = Arrays.asList(Lotto.of(collect), Lotto.of(collect1));
    }

    private static Stream<Arguments> winningEntry() {
        return Stream.of(
            Arguments.of(
                    new WinningLotto(Lotto.of(IntStream.range(1, 7)
                            .mapToObj(LottoNumber::of).collect(Collectors.toList()))
                            , LottoNumber.of(8)),
                    LottoMatch.RANK_FIRST,
                    1
            )
        );
    }
    private static Stream<Arguments> winningRateEntry() {
        return Stream.of(
            Arguments.of(
                    new WinningLotto(Lotto.of(IntStream.range(1, 7)
                            .mapToObj(LottoNumber::of).collect(Collectors.toList()))
                            , LottoNumber.of(8)),
                    ProfitMessage.PROFIT
            )
        );
    }

    @ParameterizedTest(name = "지난 주 당첨 숫자 & 보너스 숫 {0} 중 {1}개 매칭 되는 로또 {2} 개 당첨")
    @MethodSource(value = "winningEntry")
    void count_로또_총_맞춘_갯수(
            final WinningLotto winningLotto, final LottoMatch match,
            final long matchCount) {
        // given
        Lottos lottos = new Lottos(lottoList);
        // when
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        long count = lottoResult.count(match);
        // then
        assertThat(count).isEqualTo(matchCount);
    }

    @ParameterizedTest(name = "지난 주 당첨 숫자 및 보너스 숫자와 매칭하여 {0} 결과 {1}")
    @MethodSource(value = "winningRateEntry")
    void winningRate_손익_확인(
            final WinningLotto winningLotto, final ProfitMessage profitMessage) {
        // given
        Lottos lottos = new Lottos(lottoList);
        // when
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        double winningRate = lottoResult.winningRate();
        ProfitMessage actual = ProfitMessage.of(winningRate);
        // then
        assertThat(actual).isEqualTo(profitMessage);
    }
}
