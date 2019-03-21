package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;

public class LottoVendingMachineTest {

  @Test
  public void test_purchaseLotto_by_inputMoney() {

    // Given
    Money purchaseAmount = new Money(14000);

    // When
    List<Lotto> lottoList = new LottoVendingMachine().purchaseLotto(purchaseAmount);

    // Then
    assertThat(lottoList.size()).isEqualTo(14);
  }

  @Test
  public void test_winMatch_threeNumber() {

    // Given
    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;

    Lotto lotto = generateLotto(
        firstMatchNumber,
        secondMatchNumber,
        thirdMatchNumber,
        2,
        19,
        15);
    List<Number> winNumbers = new TestNumberGenerator(
        5,
        firstMatchNumber,
        secondMatchNumber,
        42,
        thirdMatchNumber,
        31).generate();

    // When
    int matchingCount = lotto.winMatch(winNumbers);

    // Then
    assertThat(matchingCount).isEqualTo(3);
  }

  @Test
  public void test_winMatch_fourNumber() {

    // Given
    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;
    int fourthMatchNumber = 36;

    Lotto lotto = generateLotto(
        firstMatchNumber,
        secondMatchNumber,
        thirdMatchNumber,
        fourthMatchNumber,
        19,
        15);
    List<Number> winNumbers = new TestNumberGenerator(
        5,
        firstMatchNumber,
        secondMatchNumber,
        fourthMatchNumber,
        thirdMatchNumber,
        31).generate();

    // When
      int matchingCount = lotto.winMatch(winNumbers);

    // Then
    assertThat(matchingCount).isEqualTo(4);
  }

  @Test
  public void test_winMatch_fiveNumber() {

    // Given
    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;
    int fourthMatchNumber = 36;
    int fifthMatchNumber = 40;

    Lotto lotto = generateLotto(
        firstMatchNumber,
        secondMatchNumber,
        thirdMatchNumber,
        fourthMatchNumber,
        fifthMatchNumber,
        15);
    List<Number> winNumbers = new TestNumberGenerator(
        fifthMatchNumber,
        firstMatchNumber,
        secondMatchNumber,
        fourthMatchNumber,
        thirdMatchNumber,
        31).generate();

    // When
    int matchingCount = lotto.winMatch(winNumbers);

    // Then
    assertThat(matchingCount).isEqualTo(5);
  }

  @Test
  public void test_winMatch_sixNumber() {

    // Given
    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;
    int fourthMatchNumber = 36;
    int fifthMatchNumber = 40;
    int sixthMatchNumber = 19;

    Lotto lotto = generateLotto(
        firstMatchNumber,
        secondMatchNumber,
        thirdMatchNumber,
        fourthMatchNumber,
        fifthMatchNumber,
        sixthMatchNumber);
    List<Number> winNumbers = new TestNumberGenerator(
        fifthMatchNumber,
        firstMatchNumber,
        secondMatchNumber,
        fourthMatchNumber,
        thirdMatchNumber,
        sixthMatchNumber).generate();

    // When
    int matchingCount = lotto.winMatch(winNumbers);

    // Then
    assertThat(matchingCount).isEqualTo(6);
  }

  public static Lotto generateLotto(
      int firstMatchNumber,
      int secondMatchNumber,
      int thirdMatchNumber,
      int fourthMatchNumber,
      int fifthMatchNumber,
      int sixthMatchNumber) {

    return new Lotto(
        new TestNumberGenerator(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            fifthMatchNumber,
            sixthMatchNumber
        ).generate()
    );
  }
}
