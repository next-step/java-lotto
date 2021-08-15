package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.money.Cache;
import step4.domain.money.Money;
import step4.domain.user.User;
import step4.domain.user.Wallet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {

    @DisplayName("10000이 있는 지갑에서 10000을 인출 할 수 있다")
    @Test
    void withDraw() {
        // Given
        Wallet givenWallet = new Wallet(new Cache(10000));
        String givenName = "Pobi";
        User user = new User(givenName, givenWallet);
        Money expectedMoney = new Cache(10000);

        // When
        Money actualMoney = user.withDraw(new Cache(10000));

        // Then
        assertThat(actualMoney).isEqualTo(expectedMoney);
    }

    @DisplayName("0원인 지갑에 10000원을 넣으면 지갑에 10000이 있다")
    @Test
    void wallet() {
        // given
        int initMoney = 0;
        Wallet givenWallet = new Wallet(new Cache(initMoney));
        User user = new User("Pobi", givenWallet);
        int givenMoney = 10000;
        Money expectedMoney = new Cache(givenMoney);

        // When
        user.save(new Cache(givenMoney));
        Wallet actualWallet = user.myWallet();

        // Then
        assertThat(actualWallet.currentMoney()).isEqualTo(expectedMoney);
    }
}
