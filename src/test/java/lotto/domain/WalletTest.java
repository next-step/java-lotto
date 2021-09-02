package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WalletTest {

    @Test
    @DisplayName("지갑에 보유 금액을 저장할 수 있다.")
    void saveMoneyTest() {

        // given
        Money money = new Money(1_000);

        // when
        Wallet wallet = new Wallet(money);

        // then
        assertThat(wallet.money()).isEqualTo(money);
    }

    @Test
    @DisplayName("보유금액을 가지고 로또를 최대한 구매할 수 있다.")
    void purchaseLottoTest() {

        // given
        Money money = new Money(10_000);
        Wallet wallet = new Wallet(money);
        Money expected = new Money(0);

        // when
        Wallet result = wallet.purchaseLotto(new ArrayList<>());

        // then
        assertThat(result.money()).isEqualTo(expected);
        assertThat(result.lottosCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("수동 로또구매 개수를 받으면 저장하고 돈을 차감할 수 있다.")
    void purchaseManualLottoTest() {

        // given
        Money money = new Money(2_000);
        Money expectMoney = new Money(0);

        Wallet wallet = new Wallet(money);
        List<String> input = new ArrayList<>(Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList())));
        lottos.add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList())));
        Lottos expectLottos = new Lottos(lottos);

        // when
        Wallet result = wallet.purchaseLotto(input);

        // then
        assertThat(result.lottos().size()).isEqualTo(2);
        assertThat(result.lottos()).isEqualTo(expectLottos);
        assertThat(result.money()).isEqualTo(expectMoney);
    }

    @Test
    @DisplayName("수동 로또 구매 갯수보다 현재 금액이 적은 경우 Exception이 반환되어야 한다.")
    void vaildateUnAvailablePurchaseManualLottoTest() {

        // given
        Money money = new Money(500);
        Wallet wallet = new Wallet(money);
        List<String> input = new ArrayList<>(Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"));

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> wallet.purchaseLotto(input))
            .withMessageMatching("로또 게임을 진행하려면 로또 가격보다 많은 돈을 넣어야 한다.");
    }

    @Test
    @DisplayName("수동 로또를 사고 남음 금액이 자동 로똘르 살 수 있다면 자동 로또를 구매해야 한다.")
    void purchaseRandomLottoByRemainMoneyTest() {

        // given
        Money money = new Money(3_000);
        Money expectMoney = new Money(0);

        Wallet wallet = new Wallet(money);
        List<String> input = new ArrayList<>(Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList())));
        lottos.add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList())));

        // when
        Wallet result = wallet.purchaseLotto(input);

        // then
        assertThat(result.lottos().size()).isEqualTo(3);
        assertThat(result.money()).isEqualTo(expectMoney);
    }

    @Test
    @DisplayName("로또를 구매하고자할 때 첫번째로 로또 한개도 살 돈이 없으면 Exception을 반환해야 한다.")
    void validatePurchaseLottoByNoMoneyTest() {

        // given
        Money money = new Money(500);
        Wallet wallet = new Wallet(money);
        List<String> input = new ArrayList<>(Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"));

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> wallet.purchaseLotto(input))
            .withMessageMatching("로또 게임을 진행하려면 로또 가격보다 많은 돈을 넣어야 한다.");
    }

    @Test
    @DisplayName("수동 로또 구매 개수를 받으면 자동 로또 구매 개수를 반환할 수 있다.")
    void calculateRandomLottoCountTest() {

        Money money = new Money(5_000);
        Money expectMoney = new Money(0);

        Wallet wallet = new Wallet(money);
        List<String> input = new ArrayList<>(Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList())));
        lottos.add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList())));
        Wallet purchaseWallet = wallet.purchaseLotto(input);

        // when
        int result = purchaseWallet.calculateRandomLottoCount(lottos.size());

        // then
        assertThat(result).isEqualTo(3);
    }

}