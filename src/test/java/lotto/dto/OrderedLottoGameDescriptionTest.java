package lotto.dto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.OrderType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class OrderedLottoGameDescriptionTest {

  @DisplayName("로또게임의 번호와 구매 타입을 출력한다.")
  @ParameterizedTest
  @CsvSource(value = {"1, 2, 3, 4, 5, 6:AUTO", "7, 9, 10, 20, 34, 45:MANUAL"}, delimiter = ':')
  void toStringTest(String given, OrderType orderType) {
    //given
    List<LottoNumber> givenNumbers = Arrays.stream(given.split(", "))
        .map(Integer::parseInt)
        .map(LottoNumber::new)
        .collect(Collectors.toList());
    LottoNumbers givenLottoNumbers = new LottoNumbers(givenNumbers);
    LottoGame givenGame = orderType == OrderType.AUTO ? LottoGame.createAutoGame(givenLottoNumbers) : LottoGame.createManualGame(givenLottoNumbers);

    //when & then
    assertAll(
        () -> assertThat(new OrderedLottoGameDescription(givenGame).toString()).hasToString(given),
        () -> assertThat(new OrderedLottoGameDescription(givenGame).getOrderType()).hasToString(orderType.getDisplayName())
    );
  }
}
