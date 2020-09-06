package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoBundleTest {

    @Test
    @DisplayName("생성자 테스트")
    void create() {
        assertThat(new LottoBundle(Arrays.asList(
                LottoNumbers.of(1, 2, 3, 4, 5, 6),
                LottoNumbers.of(7, 8, 9, 10, 12, 13),
                LottoNumbers.of(40, 41, 42, 43, 44, 45)
        ))).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("provideIllegalLottoNumbers")
    @DisplayName("생성자 예외 발생 테스트")
    void create_IllegalLottoNumbers(List<Integer> numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoBundle bundle = new LottoBundle(Arrays.asList(new LottoNumbers(numbers)));
        });
    }

    private static Stream<List<Integer>> provideIllegalLottoNumbers() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(-7, 8, 9, 10, 12, 13),
                Arrays.asList(41, 42, 43, 44, 45, 46)
        );
    }

    @ParameterizedTest
    @CsvSource({"14000, 14", "1000, 1", "0, 0", "-1000, 0"})
    @DisplayName("금액으로 구입 가능한 개수만큼 로또 번 생성")
    void buyTickets(int payment, int count) {
        assertEquals(LottoFactory.buyTickets(payment).count(), count);
    }

    @Test
    @DisplayName("등수별 당첨된 로또 장수")
    void drawing() {
        // given
        LottoNumbers winningNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6);

        LottoBundle bundle = new LottoBundle(Arrays.asList(
                LottoNumbers.of(1, 7, 8, 9, 10, 11),
                LottoNumbers.of(1, 2, 8, 9, 10, 11),
                LottoNumbers.of(1, 2, 3, 9, 10, 11),
                LottoNumbers.of(1, 2, 3, 9, 12, 13),
                LottoNumbers.of(1, 2, 3, 4, 5, 11),
                LottoNumbers.of(1, 2, 3, 4, 5, 6)
        ));

        // when
        LottoResult actual = bundle.drawing(winningNumbers);

        // then
        Map<Prize, Integer> expected = new HashMap<>();
        expected.put(Prize.FIRST, 1);
        expected.put(Prize.SECOND, 1);
        expected.put(Prize.FOURTH, 2);
        expected.put(Prize.ETC, 2);

        assertEquals(actual, new LottoResult(expected));
    }
}
