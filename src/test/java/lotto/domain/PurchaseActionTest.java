package lotto.domain;

import lotto.domain.model.LottoGames;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseActionTest {
  @ParameterizedTest
  @MethodSource("providePurchase")
  void purchase_메서드_테스트(PurchaseAction purchaseAction, LottoGames lottoGames) {
    assertThat(purchaseAction.purchase()).isEqualTo(lottoGames);
  }

  static Stream<Arguments> providePurchase() {

    List<String[]> gameNumbers = Arrays.asList(
        new String[]{"1", "2", "3", "4", "5", "6"},
        new String[]{"5", "6", "7", "8", "9", "10"}
    );
    PurchaseAction purchaseAction = new PurchaseAction(2000, gameNumbers);
    List<Lotto> lottoGames = gameNumbers.stream().map(Lotto::new).collect(Collectors.toList());

    return Stream.of(
        Arguments.of(purchaseAction, new LottoGames(lottoGames))
    );
  }
}