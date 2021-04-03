package step3.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Cash;
import step3.domain.Lotto;
import step3.domain.number.Count;
import step3.domain.number.LottoMatchingNumber;
import step3.domain.number.LottoNumbers;
import step3.strategy.LottoRandomStrategy;
import step3.strategy.LottoStrategy;
import step3.util.Splitter;

public class MartTest {
  private Mart mart;

  @BeforeEach
  void setup() {
    mart = new Mart();
  }

  @ParameterizedTest
  @CsvSource(value = {"1000:1", "14000:14", "28000:28"}, delimiter = ':')
  @DisplayName("유효한 가격으로 구매 가능한지 테스트")
  void validBuyLottoTest(int sellerMoney, int size) {
    Assertions.assertThat(mart.buyAllLotto(new Cash(sellerMoney), new LottoRandomStrategy()).quantity().showCount()).isEqualTo(size);
  }

  @ParameterizedTest
  @ValueSource(ints = {900, 999})
  @DisplayName("유효하지 않은 금액으로 로또 구매 불가한지 테스트")
  void invalidMoneyTest(int sellerMoney) {
    Assertions.assertThatThrownBy(() -> mart.buyAllLotto(new Cash(sellerMoney), new LottoRandomStrategy()))
      .isInstanceOf(RuntimeException.class)
      .hasMessage("로또를 살 수 없습니다.");
  }

  @ParameterizedTest
  @CsvSource(value = "11,12,13,14,15,16:1000", delimiter = ':')
  @DisplayName("정확한 로또 갯수대로 생성 테스트")
  void makeLottoTest(String strNumbers, int money) {
    LottoNumbers result = new LottoNumbers(Splitter.split(strNumbers));
    Lotto targetLotto = new Lotto(result);
    LottoStrategy testStrategy = lottoNumbers -> new LottoNumbers(Splitter.split(strNumbers));

    Assertions.assertThat(
      mart.buyAllLotto(new Cash(money), testStrategy)
        .matchLottos(targetLotto)
        .sendSpecificCount(new LottoMatchingNumber(6))
    ).isEqualTo(new Count(1));
  }
}
