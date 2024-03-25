package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {


    private final WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);

    @ParameterizedTest
    @DisplayName("올바르지 않은(1~45를 벗어나는 경우, 중복되는 숫자 있는 경우, )  추첨로또 생성 시 예외 발생")
    @MethodSource("invalidWinningLotto")
    void testInvalidWinningLotto(List<Integer> invalidLottoNumbers, int invalidBonusNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(invalidLottoNumbers, invalidBonusNumber));
    }

    @ParameterizedTest
    @DisplayName("추첨 로또 생성")
    @MethodSource("validWinningLotto")
    void testValidWinningLotto(List<Integer> validLottoNumbers, int validBonusNumber) {
        WinningLotto winningLotto = new WinningLotto(validLottoNumbers, validBonusNumber);
        LottoNumbers winningLottoNumbers = winningLotto.getLottoNumbers();
        LottoNumber winningBonusNumber = winningLotto.getBonusNumber();

        assertThat(winningLottoNumbers.getNumbers()).containsExactlyElementsOf(validLottoNumbers);
        assertThat(winningBonusNumber.getNumber()).isEqualTo(validBonusNumber);
    }



    @ParameterizedTest
    @DisplayName("등수 계산 테스트")
    @MethodSource("getUserNumbersAndLottoResult")
    public void winningTest(List<Integer> userNumbers, Optional<LottoWinningRank> expected) {
        LottoNumbers userLottoNumbers = new LottoNumbers(userNumbers);
        Lotto userLotto = new Lotto(userLottoNumbers);

        assertThat(userLotto.isWinningLotto(winningLotto)).isEqualTo(expected);
    }

    private static Stream<Arguments> getUserNumbersAndLottoResult() {
        return Stream.of(
                Arguments.of(List.of(6, 7, 8, 9, 10, 11), Optional.empty()),
                Arguments.of(List.of(5, 6, 7, 8, 9, 10), Optional.empty()),
                Arguments.of(List.of(4, 5, 6, 7, 8, 9), Optional.of(LottoWinningRank.FIFTH)),
                Arguments.of(List.of(3, 4, 5, 6, 7, 8), Optional.of(LottoWinningRank.FOURTH)),
                Arguments.of(List.of(2, 3, 4, 5, 6, 8), Optional.of(LottoWinningRank.THIRD)),
                Arguments.of(List.of(2, 3, 4, 5, 6, 7), Optional.of(LottoWinningRank.SECOND)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), Optional.of(LottoWinningRank.FIRST))
        );
    }


    private static Stream<Arguments> validWinningLotto() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(List.of(1, 2, 3, 4, 5, 10), 8),
                Arguments.of(List.of(40, 2, 3, 4, 5, 6), 1)
        );
    }

    private static Stream<Arguments> invalidWinningLotto() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 3),
                Arguments.of(List.of(1, 2, 2, 3, 4, 5), 8),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 58),
                Arguments.of(List.of(1, 2, 3, 4, 5, 49), 59),
                Arguments.of(List.of(1, 2, 3, 4, 5, 47), 3),
                Arguments.of(List.of(1, 2, 3, 4, 5), 6)
        );
    }

}
