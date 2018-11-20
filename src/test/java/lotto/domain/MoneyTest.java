package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class MoneyTest {

    @Test
    public void 로또_한장이_기본_금액인_상태에서_구입_가능한_로또_숫자_계산() {
        final Money money = new Money(10000);
        assertThat(money.calculateCountPurchased()).isEqualTo(10);
    }

    @Test
    public void 만원을_투자해서_로또번호_3개_맞은게_2개_생겼을때_수익률_계산() {
        final Money money = new Money(10000);
        LottoDto dto = new LottoDto(
                new Lottos(Arrays.asList(new Lotto("1,2,3,10,11,12"), new Lotto("4,5,6,10,11,12"))),
                new WinningLotto(new Lotto("1,2,3,4,5,6"), 7)
        );
        final double rate = money.calculateRate(dto);
        assertThat(rate).isEqualTo(1);
    }

    @Test
    public void 만원을_투자했는데_수동으로_3장을_미리_구매한_경우_자동으로_구매될_로또_숫자_계산() {
        final Money money = new Money(10000, 3);
        final int count = money.calculateLottoCountToPurchasedAutomatically();
        assertThat(count).isEqualTo(7);
    }

}
