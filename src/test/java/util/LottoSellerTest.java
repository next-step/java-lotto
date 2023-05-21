package util;


import domain.LottoNumber;
import domain.Money;
import dto.LottoBuyResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoSellerTest {


    @Test
    @DisplayName("로또를 구매하면 가격에 맞는 로또 개수가 나온다")
    void buyLotto() {
        // given
        Money money = new Money("10000");

        // when
        LottoBuyResult result = LottoSeller.buyLotto(money);

        // then
        assertThat(result.getLottos()).hasSize(10);
    }

    @Test
    @DisplayName("금액이 부족하면 로또를 구매할 수 없다")
    void buyLotto2() {
        // given
        Money money = new Money("900");

        // when
        LottoBuyResult result = LottoSeller.buyLotto(money);

        // then
        assertThat(result.getLottos()).hasSize(0);
    }

    @Test
    @DisplayName("수동으로 로또를 구매하면 로또가 구매된다")
    void buyManualLotto() {
        // given
        Money money = new Money("10000");
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber("1"), new LottoNumber("2"), new LottoNumber("3"), new LottoNumber("4"), new LottoNumber("5"), new LottoNumber("6"));

        // when
        LottoBuyResult result = LottoSeller.buyManualLotto(lottoNumbers, money);

        // then
        assertThat(result.getLottos()).hasSize(1);
    }

    @Test
    @DisplayName("수동으로 로또를 구매하면 남은 금액이 나온다")
    void buyManualLotto2() {
        // given
        Money money = new Money("10000");
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber("1"), new LottoNumber("2"), new LottoNumber("3"), new LottoNumber("4"), new LottoNumber("5"), new LottoNumber("6"));

        // when
        LottoBuyResult result = LottoSeller.buyManualLotto(lottoNumbers, money);

        // then
        assertThat(result.getChange()).isEqualTo(new Money("9000"));
    }
}
