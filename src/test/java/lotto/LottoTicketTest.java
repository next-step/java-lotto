package lotto;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LottoTicketTest {

  @DisplayName("로또 티켓 발급 시 로또번호가 null 또는 empty면 예외를 던진다")
  @ParameterizedTest
  @NullAndEmptySource
  void createLottoTicket_null_or_empty_numbers_throwException(List<Integer> lottoNumbers) {
    Assertions.assertThatIllegalArgumentException()
        .isThrownBy(() -> new LottoTicket(lottoNumbers))
        .withMessage("로또 번호는 빈 값일 수 없습니다");
  }

  @DisplayName("로또 티켓 발급 시 로또번호가 6개가 아니면 예외를 던진다")
  @ParameterizedTest
  @MethodSource("provideLottoNumbers")
  void createLottoTicket_not_equals_size_throwException(List<Integer> lottoNumbers) {
    Assertions.assertThatIllegalArgumentException()
        .isThrownBy(() -> new LottoTicket(lottoNumbers))
        .withMessage("로또 번호는 6개여야 합니다");
  }

  private static Stream<Arguments> provideLottoNumbers() {
    return Stream.of(
        arguments(List.of(1)),
        arguments(List.of(1, 2, 3, 4, 5, 6, 7))
    );
  }

  @DisplayName("로또 티켓 발급 시 로또번호에 중복되는 번호가 있으면 예외를 던진다")
  @Test
  void createLottoTicket_duplicate_throwException() {
    List<Integer> lottoNumbers = List.of(1, 1, 3, 4, 5, 6);
    Assertions.assertThatIllegalArgumentException()
        .isThrownBy(() -> new LottoTicket(lottoNumbers))
        .withMessage("로또 번호가 중복될 수 없습니다");
  }
}