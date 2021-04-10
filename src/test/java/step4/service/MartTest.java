package step4.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Cash;
import step4.domain.Lotto;
import step4.domain.number.Count;
import step4.domain.number.LottoNumber;
import step4.domain.number.LottoNumbers;
import step4.domain.result.Rank;
import step4.exception.InvalidPriceException;
import step4.strategy.LottoRandomStrategy;
import step4.strategy.LottoStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MartTest {
  private Mart mart;

  @BeforeEach
  void setup() {
    mart = new Mart();
  }

  @ParameterizedTest
  @CsvSource(value = {"1000:1", "14000:14", "28000:28"}, delimiter = ':')
  @DisplayName("유효한 가격으로 구매 가능한지 테스트")
  void validBuyLottoTest(Long sellerMoney, int size) {
    assertThat(
      mart.buyAllRandomLottos(new Cash(sellerMoney), new LottoRandomStrategy())
        .quantity()
        .showCount()
    ).isEqualTo(size);
  }

  @ParameterizedTest
  @ValueSource(longs = {900, 999})
  @DisplayName("유효하지 않은 금액으로 로또 구매 불가한지 테스트")
  void invalidMoneyTest(Long sellerMoney) {
    assertThatThrownBy(() ->
      mart.buyAllRandomLottos(new Cash(sellerMoney), new LottoRandomStrategy()))
      .isInstanceOf(InvalidPriceException.class)
      .hasMessage("로또를 살 수 없습니다.");
  }

  @ParameterizedTest
  @CsvSource(value = "11,12,13,14,15,16:44:1000", delimiter = ':')
  @DisplayName("정확한 로또 갯수대로 생성 테스트")
  void makeLottoTest(String strNumbers, int bonusBall, Long money) {
    Lotto targetLotto = new Lotto(new LottoNumbers(strNumbers));
    LottoStrategy testStrategy = lottoNumbers -> new LottoNumbers(strNumbers);

    Count matchingCount = mart.buyAllRandomLottos(new Cash(money), testStrategy)
      .matchLottosWithBonusBall(targetLotto, new LottoNumber(bonusBall))
      .sendSpecificCount(Rank.FIRST);

    assertThat(matchingCount).isEqualTo(new Count(1));
  }
}
