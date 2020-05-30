package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.collections.LottoResult;
import lotto.collections.WinningNumbers;
import lotto.mock.LottoTicketMock;
import lotto.mock.LottoTicketsMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningServiceTest {

  @DisplayName("로또 개수와 당첨 번호를 비교한 후, 맞은 개수를 반환한다.")
  @CsvSource(value = {"1,2,3,4,5,6 : 1,2,3,4,5,6 : 6 : 1", "1,2,3,4,5,7 : 1,2,3,4,5,6 : 5 : 1"
      , "3,4,5,6,22,33 : 1,2,3,4,5,6 : 4 : 1",
      "4,5,6,7,28,42 : 1,2,3,4,5,6 : 3 : 1"}, delimiter = ':')
  @ParameterizedTest
  public void 당첨번호_입력시_일치여부가_리턴된다(String lottoNumber, String winningNumber,
      int expectedMatchType, int matchCount) {

    //given
    List<Integer> lottoNumbersBeforeList = Arrays.stream(lottoNumber.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    LottoTicketMock mockTicket = new LottoTicketMock(lottoNumbersBeforeList);
    LottoTicketsMock mockTickets = new LottoTicketsMock(Collections.singletonList(mockTicket));

    //when
    List<Integer> winningNumbersBeforeList = Arrays.stream(winningNumber.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    WinningNumbers winningNumbers = new WinningNumbers(winningNumbersBeforeList);
    LottoResult lottoResult = new WinningService()
        .calculateLottoMatches(mockTickets, winningNumbers);

    //then
    assertThat(lottoResult.getLottoStatistics().get(expectedMatchType))
        .isEqualTo(matchCount);
  }
}
