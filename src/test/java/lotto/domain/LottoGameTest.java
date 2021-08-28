package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameTest {

  @ParameterizedTest(name = "생성 테스트 : {0}원 입력")
  @ValueSource(ints = {1000, 2500, 14000, 20000})
  void create(int money) {
    //when
    LottoGame lottoGame = new LottoGame(money);

    //then
    assertThat(lottoGame.lottos().size()).isEqualTo(money / 1000);
  }

  @ParameterizedTest(name = "잘못된 생성 테스트 : {0}원 입력")
  @ValueSource(ints = {-100, 0, 100, 999})
  void invalidCreate(int money) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LottoGame(money);
    });
  }
}
