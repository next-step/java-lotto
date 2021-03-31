package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("LottoGame 수동 로또가 없을 경우")
    @ParameterizedTest
    @CsvSource(value = {"5:5", "10:10", "14:14"}, delimiter = ':')
    void lottoGame_of_emptyManualLotto(int input, int expected) {
        List<Lotto> lottoList = new ArrayList<>();
        LottoGame lottoGame = LottoGame.of(input, lottoList);
        assertThat(lottoGame.getLottos().getSize()).isEqualTo(expected);
    }

    @DisplayName("LottoGame 수동 로또가 있을 경우")
    @ParameterizedTest
    @MethodSource("provideNumbersForSomeManualLottos")
    void lottoGame_of_someManualLotto(int input, String[] inputManualLottoNumbers, int expected) {
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();
        List<Lotto> lottoList = new ArrayList<>();

        for (String lottoNumbers : inputManualLottoNumbers) {
            lottoList.add(Lotto.of(lottoGenerator.generateAppointedLotto(lottoNumbers)));
        }
        LottoGame lottoGame = LottoGame.of(input, lottoList);
        assertThat(lottoGame.getLottos().getSize()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbersForSomeManualLottos() {
        return Stream.of(
            Arguments.of(5, new String[]{"1, 3, 5, 7, 9, 11", "1, 3, 5, 7, 9, 45"}, 5),
            Arguments.of(10, new String[]{"1, 3, 5, 7, 9, 11", "1, 3, 5, 7, 9, 45", "5, 10, 11, 12, 20, 25"}, 10),
            Arguments.of(7, new String[]{"1, 3, 5, 7, 9, 11", "1, 3, 5, 7, 9, 45", "5, 10, 11, 12, 20, 25", "10, 15, 20, 21, 5, 9"}, 7)
        );
    }
}
