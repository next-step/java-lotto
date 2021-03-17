package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.lotto.domain.type.LottoMatch;
import study.lotto.domain.type.ProfitMessage;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestMoney;
import study.lotto.view.dto.RequestWinningNumber;

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
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        List<LottoNumber> collect1 = IntStream.range(7, 13)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        lottoList = Arrays.asList(new Lotto(collect), new Lotto(collect1));
    }

    private static Stream<Arguments> winningEntry() {
        return Stream.of(
                Arguments.of(
                        new RequestWinningNumber("1,2,3,4,5,6"),
                        new RequestMoney(1000),
                        LottoMatch.RANK_FIRST,
                        1
                ),
                Arguments.of(
                        new RequestWinningNumber("4,5,6,7,8,9"),
                        new RequestMoney(2000),
                        LottoMatch.RANK_FOURTH,
                        2
                )
        );
    }

    private static Stream<Arguments> winningRateEntry() {
        return Stream.of(
                Arguments.of(
                        new RequestWinningNumber("1,2,3,4,5,6"),
                        new RequestMoney(2000),
                        ProfitMessage.PROFIT
                        ),
                Arguments.of(
                        new RequestWinningNumber("1,2,14,11,12,13"),
                        new RequestMoney(2000),
                        ProfitMessage.LOSS
                        ),
                Arguments.of(
                        new RequestWinningNumber("1,2,3,16,14,15"),
                        new RequestMoney(5000),
                        ProfitMessage.BREAK_POINT
                        )

        );
    }
    @ParameterizedTest(name = "지난 주 당첨 숫자 {0} 중 {1}원으로 구매하여 매칭되는 숫자 {2}개로 로또 {3} 개 당첨")
    @MethodSource(value = "winningEntry")
    void count_로또_총_맞춘_갯수(RequestWinningNumber winningNumber, RequestMoney requestMoney, LottoMatch rank,
                          long matchCount) {
        // given
        Lottos lottos = new Lottos(lottoList, requestMoney);
        // when
        LottoResult lottoResult = new LottoResult(winningNumber, lottos);
        long count = lottoResult.count(rank);
        // then
        assertThat(count).isEqualTo(matchCount);
    }

    @ParameterizedTest(name = "지난 주 당첨 숫자 {0} 중 {1}원으로 구매하여 {2}")
    @MethodSource(value = "winningRateEntry")
    void winningRate_손익_확인(RequestWinningNumber winningNumber, RequestMoney requestMoney,
                            ProfitMessage profitMessage) {
        // given
        Lottos lottos = new Lottos(lottoList, requestMoney);
        // when
        LottoResult lottoResult = new LottoResult(winningNumber, lottos);
        double winningRate = lottoResult.winningRate();
        ProfitMessage actual = ProfitMessage.of(winningRate);
        // then
        assertThat(actual).isEqualTo(profitMessage);
    }
}
