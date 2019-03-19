package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class LottoVendingMachineTest {

  @Test
  public void test_purchaseLotto_by_inputMoney() {

    // Given
    int purchaseAmount = 14000;

    // When
    List<Lotto> lottoList = LottoVendingMachine.purchaseLotto(purchaseAmount);

    // Then
    assertThat(lottoList.size()).isEqualTo(14);
  }

  @Test
  public void test_generateLottoNumbers_sixNumber() {

    // When
    List<Number> generateNumber = LottoVendingMachine.generateLottoNumbers();

    // Then
    assertThat(generateNumber.size()).isEqualTo(6);
  }

  @Test
  public void test_winLotto_threeNumber() {

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
    List<Number> winNumbers = generateNumberArray(
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
  public void test_winLotto_fourNumber() {

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
    List<Number> winNumbers = generateNumberArray(
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
  public void test_winLotto_fiveNumber() {

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
    List<Number> winNumbers = generateNumberArray(
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
  public void test_winLotto_sixNumber() {

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
    List<Number> winNumbers = generateNumberArray(
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

  private Lotto generateLotto(
      int firstMatchNumber,
      int secondMatchNumber,
      int thirdMatchNumber,
      int fourthMatchNumber,
      int fifthMatchNumber,
      int sixthMatchNumber) {

    return new Lotto(
        generateNumberArray(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            fifthMatchNumber,
            sixthMatchNumber
        )
    );
  }

  private List<Number> generateNumberArray(
      int firstMatchNumber,
      int secondMatchNumber,
      int thirdMatchNumber,
      int fourthMatchNumber,
      int fifthMatchNumber,
      int sixthMatchNumber) {

    return Arrays.asList(
        new Number(firstMatchNumber),
        new Number(secondMatchNumber),
        new Number(thirdMatchNumber),
        new Number(fourthMatchNumber),
        new Number(fifthMatchNumber),
        new Number(sixthMatchNumber)
    );
  }

  @Test
  public void test_totalWinMoney() {

    // Given
    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;
    int fourthMatchNumber = 36;
    int fifthMatchNumber = 40;
    int sixthMatchNumber = 19;

    List<Lotto> lottoList = Arrays.asList(
        generateLotto(
            5,
            firstMatchNumber,
            secondMatchNumber,
            42,
            thirdMatchNumber,
            31),
        generateLotto(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            1,
            14),
        generateLotto(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            fifthMatchNumber,
            45),
        generateLotto(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            fifthMatchNumber,
            sixthMatchNumber)
    );
    List<Number> winNumbers = generateNumberArray(
        fifthMatchNumber,
        firstMatchNumber,
        secondMatchNumber,
        fourthMatchNumber,
        thirdMatchNumber,
        sixthMatchNumber);

    // When
    Money winMoney = LottoVendingMachine.totalWinMoney(lottoList, winNumbers);

    // Then
    assertThat(winMoney).isEqualTo(new Money(5000 + 50000 + 1500000 + 2000000000));
  }

  @Test
  public void test_winMoney_three() {

    // Given
    int matchCount = 3;
    int winCount = 2;

    // When
    Money winMoney = LottoVendingMachine.winMoney(matchCount, (long)winCount);

    // Then
    assertThat(winMoney).isEqualTo(new Money(5000 * winCount));
  }

  @Test
  public void test_winMoney_four() {

    // Given
    int matchCount = 4;
    int winCount = 3;

    // When
    Money winMoney = LottoVendingMachine.winMoney(matchCount, (long)winCount);

    // Then
    assertThat(winMoney).isEqualTo(new Money(50000 * winCount));
  }

  @Test
  public void test_winMoney_five() {

    // Given
    int matchCount = 5;
    int winCount = 1;

    // When
    Money winMoney = LottoVendingMachine.winMoney(matchCount, (long)winCount);

    // Then
    assertThat(winMoney).isEqualTo(new Money(1500000 * winCount));
  }

  @Test
  public void test_winMoney_six() {

    // Given
    int matchCount = 6;
    int winCount = 2;

    // When
    Money winMoney = LottoVendingMachine.winMoney(matchCount, (long)winCount);

    // Then
    assertThat(winMoney).isEqualTo(new Money(2000000000 * winCount));
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_winMoney_illegalArgumentException() {

    // Given
    int matchCount = 1;
    int winCount = 2;

    // When
    LottoVendingMachine.winMoney(matchCount, (long)winCount);
  }

  @Test
  public void test_yield() {

    // Given
    Money purchaseMoney = new Money(14000);
    Money winMoney = new Money(5000);

    // When
    String yield = LottoVendingMachine.yield(purchaseMoney, winMoney);

    // Then
    assertThat(yield).isEqualTo("0.36");
  }
}
