package lottogame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoPriceTest {
    private LottoPrice price;

    @Test
    void 로또가격_유효성_체크() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    price = new LottoPrice(500);
                }).withMessage("최소 금액 1000원 보다 작은 금액이 입력되었습니다. 다시 프로그램을 실행 후 올바른 가격을 입력해주세요.");
    }

    @Test
    void 입력가격에_따른_로또게임_횟수_유효성_체크() {
        price = new LottoPrice(5000);
        assertThat(price.convertPriceToNumberOfGame()).isEqualTo(5);
    }
}