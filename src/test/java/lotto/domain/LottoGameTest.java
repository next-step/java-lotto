package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    int money = 14000;
    List<String> manualLottoList = Arrays.asList(
        "8, 21, 23, 41, 42, 43",
        "3, 5, 11, 16, 32, 38",
        "7, 11, 16, 35, 36, 44"
    );

    //when
    LottoGame lottoGame = new LottoGame(money, manualLottoList);

    //then
    assertThat(lottoGame.lottos().size()).isEqualTo(14);
    assertThat(lottoGame.lottos()).contains(
        Lotto.issueByManual(Arrays.asList(8, 21, 23, 41, 42, 43)),
        Lotto.issueByManual(Arrays.asList(3, 5, 11, 16, 32, 38)),
        Lotto.issueByManual(Arrays.asList(7, 11, 16, 35, 36, 44)));
  }

  @Test
  @DisplayName("잘못된 생성 테스트(로또 1개의 가격보다 적은 금액 입력했을때)")
  void invalidCreateTest1() {
    //given
    int money = 900;
    List<String> manualLottoList = Collections.emptyList();

    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LottoGame(money, manualLottoList);
    });
  }

  @Test
  @DisplayName("잘못된 생성 테스트(구입금액보다 더 많은 로또를 수동으로 구매했을때)")
  void invalidCreateTest2() {
    //given
    int money = 2000;
    List<String> manualLottoList = Arrays.asList(
        "8, 21, 23, 41, 42, 43",
        "3, 5, 11, 16, 32, 38",
        "7, 11, 16, 35, 36, 44"
    );

    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LottoGame(money, manualLottoList);
    });
  }

  @ParameterizedTest(name = "구매가능한 로또개수 테스트 : {0}원 입력")
  @ValueSource(ints = {1000, 2500, 14000, 20000})
  void name(int money) {
    //when
    Money purchaseMoney = new Money(money);

    //then
    assertThat(LottoGame.purchaseCnt(purchaseMoney)).isEqualTo(purchaseMoney.value() / 1000);
  }

  @Test
  @DisplayName("수동, 자동으로 생성된 로또 개수 반환 테스트")
  void manualLottoCntAndAutoLottoCntTest() {
    //given
    int money = 14000;
    List<String> manualLottoList = Arrays.asList(
        "8, 21, 23, 41, 42, 43",
        "3, 5, 11, 16, 32, 38",
        "7, 11, 16, 35, 36, 44"
    );

    //when
    LottoGame lottoGame = new LottoGame(money, manualLottoList);

    //then
    assertThat(lottoGame.manualLottoCnt()).isEqualTo(3);
    assertThat(lottoGame.autoLottoCnt()).isEqualTo(11);
  }
}
