package study.lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.WinningLotto;
import study.lotto.domain.type.LottoMatch;
import study.lotto.domain.type.ProfitMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private static Stream<Arguments> lottoListEntry() {
        return Stream.of(
                Arguments.of("3,4,5,6,7,8", LottoNumber.of(10), LottoMatch.RANK_THIRD, 1),
                Arguments.of("4,5,6,7,8,9", LottoNumber.of(10), LottoMatch.RANK_FOURTH, 1),
                Arguments.of("5,6,7,8,9,10", LottoNumber.of(11), LottoMatch.RANK_ETC, 2)
        );
    }

    private static Stream<Arguments> winningRateEntry() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", LottoNumber.of(10), 666666.6666666666),
                Arguments.of("2,3,4,5,6,7", LottoNumber.of(10), 500.0),
                Arguments.of("3,4,5,6,7,8", LottoNumber.of(10), 18.333333333333332),
                Arguments.of("4,5,6,7,8,9", LottoNumber.of(10), 18.333333333333332),
                Arguments.of("5,6,7,8,9,10", LottoNumber.of(11), 10000.0)
        );
    }

    private static Stream<Arguments> profitMessageEntry() {
        return Stream.of(
                Arguments.of("2,3,4,5,6,7", LottoNumber.of(1), "이익"),
                Arguments.of("13,14,15,16,17,18", LottoNumber.of(1), "손해")
        );
    }

    private List<Lotto> lottoList;

    @BeforeEach
    void setUp() {
        lottoList = Arrays.asList(
                Lotto.of(IntStream.range(1, 7).mapToObj(LottoNumber::of)
                        .collect(Collectors.toList())),
                Lotto.of(IntStream.range(6, 12).mapToObj(LottoNumber::of)
                        .collect(Collectors.toList())),
                Lotto.of(IntStream.range(9, 15).mapToObj(LottoNumber::of)
                        .collect(Collectors.toList()))
        );
    }

    @DisplayName(value = "기본 생성 객체 생성 테스트")
    @Test
    void lottos_객체_생성() {
        // given
        Lottos lottos = new Lottos(lottoList);
        // then
        assertThat(lottos).isEqualTo(new Lottos(lottoList));
    }

    @ParameterizedTest(name = "당첨번호: {0}, 보너스 숫자: {1} 손익 메시지 : {2} ")
    @MethodSource(value = "profitMessageEntry")
    void profitMessage_이익률_테스트(String winningNumbers, LottoNumber bonusNumber, String expected) {
        // given
        Lottos lottos = new Lottos(lottoList);
        // when
        WinningLotto winningLotto1 = WinningLotto.of(winningNumbers, bonusNumber);
        double profitValue = lottos.winningRate(winningLotto1);
        ProfitMessage of = ProfitMessage.of(profitValue);
        // then
        assertThat(of).hasToString(expected);
    }

    @ParameterizedTest(name = "당첨 번호: {0}, 보너스 번호 {1} 중 {2} 개의 번호를 맞춘 로또가 {3}개")
    @MethodSource(value = "lottoListEntry")
    void testCase5(String winningNumbers, LottoNumber bonusNumber, LottoMatch match, long expected) {
        // given
        Lottos lottos = new Lottos(lottoList);
        // when
        long statics = lottos.matchStatics(match, WinningLotto.of(winningNumbers, bonusNumber));
        // then
        assertThat(statics).isEqualTo(expected);
    }

    @ParameterizedTest(name = "당첨 번호: {0}, 보너스 번호 {1} 중 이익률 {2}")
    @MethodSource(value = "winningRateEntry")
    void testCase6(String winningNumbers, LottoNumber bonusNumber, double expected) {
        // given
        Lottos lottos = new Lottos(lottoList);
        // when
        double winningRate = lottos.winningRate(WinningLotto.of(winningNumbers, bonusNumber));
        // then
        assertThat(winningRate).isEqualTo(expected);
    }
}
