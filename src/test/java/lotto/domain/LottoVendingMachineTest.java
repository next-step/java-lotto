package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.view.TestConsoleInputView;
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

  private Lotto generateLotto(
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
    List<Number> winNumbers = new TestNumberGenerator(
        fifthMatchNumber,
        firstMatchNumber,
        secondMatchNumber,
        fourthMatchNumber,
        thirdMatchNumber,
        sixthMatchNumber).generate();

    // When
    Money winMoney = new LottoVendingMachine().totalWinMoney(lottoList, winNumbers);

    // Then
    assertThat(winMoney).isEqualTo(new Money(5000 + 50000 + 1500000 + 2000000000));
  }

  @Test
  public void test_winMoney_three() {

    // Given
    int matchCount = 3;
    int winCount = 2;

    // When
    Money winMoney = new LottoVendingMachine().winMoney(matchCount, (long)winCount);

    // Then
    assertThat(winMoney).isEqualTo(new Money(5000 * winCount));
  }

  @Test
  public void test_winMoney_four() {

    // Given
    int matchCount = 4;
    int winCount = 3;

    // When
    Money winMoney = new LottoVendingMachine().winMoney(matchCount, (long)winCount);

    // Then
    long resultMoney = (long)50000 * winCount;
    assertThat(winMoney).isEqualTo(new Money(resultMoney));
  }

  @Test
  public void test_winMoney_five() {

    // Given
    int matchCount = 5;
    int winCount = 1;

    // When
    Money winMoney = new LottoVendingMachine().winMoney(matchCount, (long)winCount);

    // Then
    long resultMoney = (long)1500000 * winCount;
    assertThat(winMoney).isEqualTo(new Money(resultMoney));
  }

  @Test
  public void test_winMoney_six() {

    // Given
    int matchCount = 6;
    int winCount = 2;

    // When
    Money winMoney = new LottoVendingMachine().winMoney(matchCount, (long)winCount);

    // Then
    long resultMoney = (long)2000000000 * winCount;
    assertThat(winMoney).isEqualTo(new Money(resultMoney));
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_winMoney_illegalArgumentException() {

    // Given
    int matchCount = 1;
    int winCount = 2;

    // When
    new LottoVendingMachine().winMoney(matchCount, (long)winCount);
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
