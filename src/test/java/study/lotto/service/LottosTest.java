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
import study.lotto.view.dto.RequestMoney;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private static Stream<Arguments> lottoListEntry() {
        return Stream.of(
                Arguments.of(
                        new Lotto(IntStream.range(3, 9)
                                .mapToObj(LottoNumber::new).collect(Collectors.toList())),
                        new LottoNumber(10),
                        LottoMatch.RANK_THIRD,
                        1
                ),
                Arguments.of(
                        new Lotto(IntStream.range(4, 10)
                                .mapToObj(LottoNumber::new).collect(Collectors.toList())),
                        new LottoNumber(10),
                        LottoMatch.RANK_FOURTH,
                        1
                ),
                Arguments.of(
                        new Lotto(IntStream.range(5, 11)
                                .mapToObj(LottoNumber::new).collect(Collectors.toList())),
                        new LottoNumber(11),
                        LottoMatch.RANK_ETC,
                        2
                )
        );
    }

    private static Stream<Arguments> winningRateEntry() {
        return Stream.of(
                Arguments.of(
                        new Lotto(IntStream.range(1, 7)
                                .mapToObj(LottoNumber::new).collect(Collectors.toList())),
                        new LottoNumber(10),
                        666666.6666666666
                ),
                Arguments.of(
                        new Lotto(IntStream.range(2, 8)
                                .mapToObj(LottoNumber::new).collect(Collectors.toList())),
                        new LottoNumber(10),
                        500.0
                ),
                Arguments.of(
                        new Lotto(IntStream.range(3, 9)
                                .mapToObj(LottoNumber::new).collect(Collectors.toList())),
                        new LottoNumber(10),
                        18.333333333333332
                ),
                Arguments.of(
                        new Lotto(IntStream.range(4, 10)
                                .mapToObj(LottoNumber::new).collect(Collectors.toList())),
                        new LottoNumber(10),
                        18.333333333333332
                ),
                Arguments.of(
                        new Lotto(IntStream.range(5, 11)
                                .mapToObj(LottoNumber::new).collect(Collectors.toList())),
                        new LottoNumber(11),
                        10000.0
                )
        );
    }

    private static Stream<Arguments> profitMessageEntry() {
        return Stream.of(
                Arguments.of(
                        new Lotto(IntStream.range(2, 8).mapToObj(LottoNumber::new)
                                .collect(Collectors.toList())),
                        new LottoNumber(1),
                        "이익"
                ),
                Arguments.of(
                        new Lotto(IntStream.range(13, 17).mapToObj(LottoNumber::new)
                                .collect(Collectors.toList())),
                        new LottoNumber(1),
                        "손해"
                )
        );
    }

    private List<Lotto> lottoList;

    @BeforeEach
    void setUp() {
        lottoList = Arrays.asList(
                new Lotto(IntStream.range(1, 7).mapToObj(LottoNumber::new)
                                .collect(Collectors.toList())),
                new Lotto(IntStream.range(6, 12).mapToObj(LottoNumber::new)
                                .collect(Collectors.toList())),
                new Lotto(IntStream.range(9, 15).mapToObj(LottoNumber::new)
                                .collect(Collectors.toList()))
        );
    }

    @DisplayName(value = "기본 생성 객체 생성 테스트")
    @Test
    void lottos_객체_생성() {

        // when
        RequestMoney money = new RequestMoney(3000);
        Lottos lottos = new Lottos(lottoList, money);
        // then
        assertThat(lottos).isEqualTo(lottos);
    }

    @ParameterizedTest(name = "당첨번호: {0}, 보너스 숫자: {1} 손익 메시지 : {2} ")
    @MethodSource(value = "profitMessageEntry")
    void profitMessage_이익률_테스트(Lotto winningNumbers, LottoNumber bonusNumber, String expected) {

        // when
        Lottos lottos = new Lottos(lottoList, new RequestMoney(3000));

        WinningLotto winningLotto1 = new WinningLotto(winningNumbers, bonusNumber);
        double profitValue = lottos.winningRate(winningLotto1);

        ProfitMessage of = ProfitMessage.of(profitValue);

        // then
        assertThat(of.toString()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "당첨 번호: {0}, 보너스 번호 {1} 중 {2} 개의 번호를 맞춘 로또가 {3}개")
    @MethodSource(value = "lottoListEntry")
    void testCase5(Lotto winningNumbers, LottoNumber bonusNumber, LottoMatch match, long expected) {
        // given
        Lottos lottos = new Lottos(lottoList, new RequestMoney(3000));
        // when
        long statics = lottos.statics(
                match,
                new WinningLotto(winningNumbers, bonusNumber)
        );
        // then
        assertThat(statics).isEqualTo(expected);
    }

    @ParameterizedTest(name = "당첨 번호: {0}, 보너스 번호 {1} 중 이익률 {2}")
    @MethodSource(value = "winningRateEntry")
    void testCase6(Lotto winningNumbers, LottoNumber bonusNumber, double expected) {
        // given
        Lottos lottos = new Lottos(lottoList, new RequestMoney(3000));
        // when
        double winningRate = lottos.winningRate(new WinningLotto(winningNumbers, bonusNumber));
        // then
        assertThat(winningRate).isEqualTo(expected);
    }
}
