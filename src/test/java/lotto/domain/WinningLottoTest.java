package lotto.domain;

import lotto.exception.LottoExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {

    @DisplayName("당첨 번호 정상 입력 시, 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:7", "3, 16, 25, 41, 4, 1:5"}, delimiter = ':')
    void create(String winningLottoNumbers, String bonusNumber) {
        assertThat(WinningLotto.of(winningLottoNumbers, bonusNumber));
    }

    @DisplayName("당첨 번호 개수 오입력 시, 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3:7", "1, 2, 3, 4, 5, 6, 7:10"}, delimiter = ':')
    void create_invalid_count(String winningLottoNumbers, String bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(winningLottoNumbers, bonusNumber))
                .withMessage(LottoExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
    }

    @DisplayName("당첨 번호 범위 오입력 시, 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"42, 1, 5, 88, 99, 100:33", "-1, 4, 5, 10, 16, 23:27"}, delimiter = ':')
    void create_invalid_range(String winningLottoNumbers, String bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(winningLottoNumbers, bonusNumber))
                .withMessage(LottoExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
    }

    @DisplayName("당첨 번호 숫자 미입력 시 , 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"string:3", "한글한글:17"}, delimiter = ':')
    void create_invalid_number(String winningLottoNumbers, String bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(winningLottoNumbers, bonusNumber))
                .withMessage("숫자를 제대로 입력해주세요.");
    }

    @DisplayName("보너스 번호 범위 오입력 시, 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:100", "2, 4, 6, 8, 10, 12:-20"}, delimiter = ':')
    void create_bonus_number_invalid_range(String winningLottoNumbers, String bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(winningLottoNumbers, bonusNumber))
                .withMessage(LottoExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
    }

    @DisplayName("보너스 번호 중복 입력 시, 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:1", "2, 4, 5, 10, 16, 23:4"}, delimiter = ':')
    void create_bonus_number_duplication(String winningLottoNumbers, String bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(winningLottoNumbers, bonusNumber))
                .withMessage(LottoExceptionMessage.INVALID_BONUS_NUMBER_DUPLICATION);
    }

    @DisplayName("보너스 번호 숫자 미입력 시 , 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"15, 23, 17, 12, 33, 41:보너스", "10, 2, 7, 44, 29, 31:번호"}, delimiter = ':')
    void create_bonus_number_invalid_number(String winningLottoNumbers, String bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(winningLottoNumbers, bonusNumber))
                .withMessage("숫자를 제대로 입력해주세요.");
    }

    @DisplayName("당첨번호 일치 개수에 따른 LottoRank 생성 테스트")
    @ParameterizedTest
    @MethodSource("makeLottoNumbersForWinningRank")
    void getWinningRank_with_bonus_number(String selectedLottoNumber, String winningNumber,
                                          String bonusNumber, LottoRank lottoRank) {
        LottoTicketMaker lottoTicketMaker = new LottoTicketOneSelectMaker(selectedLottoNumber);

        LottoTicket lottoTicket = lottoTicketMaker.create(BuyCount.of(1)).get(0);

        assertThat(WinningLotto.of(winningNumber, bonusNumber).getWinningRank(lottoTicket)).isEqualTo(lottoRank);
    }

    private static Stream<Arguments> makeLottoNumbersForWinningRank() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,5,6", "7", LottoRank.FIRST),
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,5,10", "6", LottoRank.SECOND_BONUS),
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,5,10", "11", LottoRank.SECOND),
                Arguments.of("1,2,3,4,5,6", "11,12,13,14,15,16", "17", LottoRank.DROP)

        );
    }

}
