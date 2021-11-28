package lotto.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningTicketTest {

  @ParameterizedTest
  @MethodSource("makeLottoNumberList")
  @DisplayName("6개의 로또 번호 및 보너스 번호를 이용해 Winning ticket을 생성한다.")
  void create(LottoTicket lottoTicket, LottoNumber bonusNumber) {
    WinningTicket ticket = new WinningTicket(lottoTicket, bonusNumber);
    assertArrayEquals(ticket.getNumbers().toArray(), lottoTicket.getNumbers().toArray());
    assertEquals(ticket.getBonusNumber(), bonusNumber);
  }

  @ParameterizedTest
  @MethodSource("makeDuplicatedBonusNumber")
  @DisplayName("기존 6개의 당첨숫자중 하나와 보너스 숫자가 중복으로 겹치면 exception을 던진다.")
  void createWrongSize(LottoTicket lottoTicket, LottoNumber bonusNumber) {
    assertThrows(IllegalArgumentException.class, () -> new WinningTicket(lottoTicket, bonusNumber));
  }

  private static Stream<Arguments> makeLottoNumberList() {
    return Stream.of(
            Arguments.of(new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(15), new LottoNumber(40),
                    new LottoNumber(25), new LottoNumber(30), new LottoNumber(4))), new LottoNumber(7)),
            Arguments.of(new LottoTicket(Arrays.asList(new LottoNumber(4), new LottoNumber(10), new LottoNumber(26),
                    new LottoNumber(35), new LottoNumber(45), new LottoNumber(12))), new LottoNumber(7)));
  }

  private static Stream<Arguments> makeDuplicatedBonusNumber() {
    return Stream.of(
            Arguments.of(new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(15), new LottoNumber(40),
                    new LottoNumber(25), new LottoNumber(30), new LottoNumber(4))), new LottoNumber(1)),
            Arguments.of(new LottoTicket(Arrays.asList(new LottoNumber(4), new LottoNumber(10), new LottoNumber(26),
                    new LottoNumber(35), new LottoNumber(45), new LottoNumber(12))), new LottoNumber(35)));
  }
}