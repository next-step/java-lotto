package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class LottoVendingMachineTest {

  @Test
  public void test_purchaseLotto_by_inputMoney() {

    // Given
    int insertMoney = 14000;

    // When
    Money purchaseAmount = new Money(insertMoney);
    MyLottos myLottos = new LottoVendingMachine().purchaseLotto(purchaseAmount);

    // Then
    assertThat(myLottos.getBuyMoney().amount()).isEqualTo(insertMoney);
    assertThat(myLottos.getLottos().size()).isEqualTo(14);
  }

  @Test
  public void test_winMatch_threeNumber() {

    // Given
    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;

    Lotto lotto = new Lotto(Arrays.asList(
        firstMatchNumber,
        secondMatchNumber,
        thirdMatchNumber,
        2,
        19,
        15));
    List<Integer> winNumbers = Arrays.asList(
        5,
        firstMatchNumber,
        secondMatchNumber,
        42,
        thirdMatchNumber,
        31);

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

    Lotto lotto = new Lotto(Arrays.asList(
        firstMatchNumber,
        secondMatchNumber,
        thirdMatchNumber,
        fourthMatchNumber,
        19,
        15));
    List<Integer> winNumbers = Arrays.asList(
        5,
        firstMatchNumber,
        secondMatchNumber,
        fourthMatchNumber,
        thirdMatchNumber,
        31);

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

    Lotto lotto = new Lotto(Arrays.asList(
        firstMatchNumber,
        secondMatchNumber,
        thirdMatchNumber,
        fourthMatchNumber,
        fifthMatchNumber,
        15));
    List<Integer> winNumbers = Arrays.asList(
        fifthMatchNumber,
        firstMatchNumber,
        secondMatchNumber,
        fourthMatchNumber,
        thirdMatchNumber,
        31);

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

    Lotto lotto = new Lotto(Arrays.asList(
        firstMatchNumber,
        secondMatchNumber,
        thirdMatchNumber,
        fourthMatchNumber,
        fifthMatchNumber,
        sixthMatchNumber));
    List<Integer> winNumbers = Arrays.asList(
        fifthMatchNumber,
        firstMatchNumber,
        secondMatchNumber,
        fourthMatchNumber,
        thirdMatchNumber,
        sixthMatchNumber);

    // When
    int matchingCount = lotto.winMatch(winNumbers);

    // Then
    assertThat(matchingCount).isEqualTo(6);
  }
}
