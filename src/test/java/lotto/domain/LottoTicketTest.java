package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTicketTest {

  @ParameterizedTest
  @MethodSource("makeLottoNumberList")
  @DisplayName("6개의 로또 번호를 이용해 Lotto ticket을 생성한다.")
  void create(List<LottoNumber> lottoNumbers, int size) {
    LottoTicket ticket = new LottoTicket(lottoNumbers);
    assertEquals(ticket.size(), size);
    assertArrayEquals(ticket.getNumbers().toArray(), lottoNumbers.toArray());
  }

  @ParameterizedTest
  @MethodSource("makeMoreThanBigSizeLottoNumberList")
  @DisplayName("6개 이상의 로또 번호를 이용해 Lotto ticket을 생성한다.")
  void createWrongSize(List<LottoNumber> lottoNumbers) {
    assertThrows(IllegalArgumentException.class, () -> new LottoTicket(lottoNumbers));
  }

  private static Stream<Arguments> makeLottoNumberList() {
    return Stream.of(
            Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(15), new LottoNumber(40),
            new LottoNumber(25), new LottoNumber(15), new LottoNumber(4)), 6),
            Arguments.of(Arrays.asList(new LottoNumber(4), new LottoNumber(10), new LottoNumber(26),
            new LottoNumber(35), new LottoNumber(45), new LottoNumber(12)), 6));
  }

  private static Stream<Arguments> makeMoreThanBigSizeLottoNumberList() {
    return Stream.of(
            Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(15), new LottoNumber(40),
                    new LottoNumber(25), new LottoNumber(15), new LottoNumber(4), new LottoNumber(20))),
            Arguments.of(Arrays.asList(new LottoNumber(4), new LottoNumber(10), new LottoNumber(26),
                    new LottoNumber(35), new LottoNumber(45), new LottoNumber(12), new LottoNumber(1),
                    new LottoNumber(7), new LottoNumber(19))));
  }
}
