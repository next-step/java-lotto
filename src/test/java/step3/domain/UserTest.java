package step3.domain;

import org.junit.jupiter.api.Test;
import step3.domain.money.Cache;
import step3.domain.money.Money;
import step3.domain.user.User;
import step3.domain.user.Wallet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {

    @Test
    void _10000이_있는_지갑에서_10000을_인출_할_수_있다() {
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

    @Test
    void _0원인_지갑에_10000원을_넣으면_지갑에_10000이_있다() {
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
