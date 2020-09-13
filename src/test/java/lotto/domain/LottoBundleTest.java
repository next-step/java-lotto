package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoBundleTest {

    @Test
    @DisplayName("개수만큼 수동으로 입력한 로또 생성")
    void addTickets() {
        // given
        LottoBundle actual = new LottoBundle();

        List<LottoNumbers> pickedNumbers = Arrays.asList(
                LottoNumbers.of(1, 2, 3, 4, 5, 6),
                LottoNumbers.of(7, 8, 9, 10, 11, 12),
                LottoNumbers.of(13, 14, 15, 16, 17, 18)
        );

        // when
        actual.addTickets(pickedNumbers);

        // then
        assertEquals(actual, new LottoBundle(pickedNumbers));
    }

    @ParameterizedTest
    @MethodSource("provideNumbersAndResult")
    @DisplayName("추첨 결과 확인(보너스 포함된 경우와 포함되지 않은 경우)")
    void drawing(List<LottoNumbers> tickets, LottoResult expected) {
        // given
        WinningLotto winningNumbers = WinningLotto.of(45, 1, 2, 3, 4, 5, 6);

        // when
        LottoResult actual = new LottoBundle(tickets).drawing(winningNumbers);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbersAndResult() {
        return Stream.of(provideNoBonusArguments(), provideBonusArguments());
    }

    private static Arguments provideNoBonusArguments() {
        List<LottoNumbers> noBonusNumbers = Arrays.asList(
                LottoNumbers.of(7, 8, 9, 10, 11, 12),
                LottoNumbers.of(1, 2, 9, 10, 11, 12),
                LottoNumbers.of(1, 2, 3, 7, 8, 9),
                LottoNumbers.of(1, 2, 3, 4, 8, 9),
                LottoNumbers.of(1, 2, 3, 4, 5, 9),
                LottoNumbers.of(1, 2, 3, 4, 5, 6)
        );
        List<Prize> noBonusResult = Arrays.asList(
                Prize.ETC, Prize.ETC,
                Prize.FIFTH,
                Prize.FOURTH,
                Prize.THIRD,
                Prize.FIRST
        );
        return Arguments.of(noBonusNumbers, new LottoResult(noBonusResult));
    }

    private static Arguments provideBonusArguments() {
        List<LottoNumbers> bonusNumbers = Arrays.asList(
                LottoNumbers.of(7, 8, 9, 10, 11, 12),
                LottoNumbers.of(1, 2, 9, 10, 11, 12),
                LottoNumbers.of(1, 2, 3, 7, 8, 9),
                LottoNumbers.of(1, 2, 3, 4, 8, 9),
                LottoNumbers.of(1, 2, 3, 4, 5, 45),
                LottoNumbers.of(1, 2, 3, 4, 5, 6)
        );
        List<Prize> bonusResult = Arrays.asList(
                Prize.ETC, Prize.ETC,
                Prize.FIFTH,
                Prize.FOURTH,
                Prize.SECOND,
                Prize.FIRST
        );
        return Arguments.of(bonusNumbers, new LottoResult(bonusResult));
    }
}
