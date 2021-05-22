package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.util.ReflectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BankTest {
    private Lotto answerLotto;

    @BeforeEach
    void setUp() {
        answerLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));
    }

    @DisplayName("로또번호가 일치하는만큼 LottoWallet에 잘 저장되는지")
    @ParameterizedTest
    @MethodSource("parametersForLottos")
    void lottos_result(final List<Lotto> lottoList) {
        //given
        Lottos lottos = new Lottos(lottoList);
        Money money = new Money(6000);
        Bank bank = new Bank(answerLotto);

        //when
        LottoWallet lottoWallet = bank.matchLottos(lottos, money);
        Map<LottoResult, Integer> lottoResultCounts = lottoWallet.getLottoResultCounts();

        //then
        assertThat(lottoResultCounts.get(LottoResult.FIRST)).isEqualTo(1);
        assertThat(lottoResultCounts.get(LottoResult.SECOND)).isEqualTo(1);
        assertThat(lottoResultCounts.get(LottoResult.THIRD)).isEqualTo(1);
        assertThat(lottoResultCounts.get(LottoResult.FOURTH)).isEqualTo(2);
    }

    static Stream<Arguments> parametersForLottos() {
        return Stream.of(arguments(Arrays.asList(
                new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))), //LottoResult.FIRST
                new Lotto(Arrays.asList(new LottoNumber(11), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))), //LottoResult.SECOND
                new Lotto(Arrays.asList(new LottoNumber(11), new LottoNumber(22), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))), //LottoResult.THIRD
                new Lotto(Arrays.asList(new LottoNumber(11), new LottoNumber(22), new LottoNumber(33),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))), //LottoResult.FOURTH
                new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(22), new LottoNumber(33),
                        new LottoNumber(44), new LottoNumber(5), new LottoNumber(6))), //LottoResult.FOURTH
                new Lotto(Arrays.asList(new LottoNumber(11), new LottoNumber(22), new LottoNumber(33),
                        new LottoNumber(44), new LottoNumber(5), new LottoNumber(6))) //LottoResult.NONE
        )));
    }
}
