package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoFactoryTest {

    private Lotto checkLotto;
    private LottoFactory lottoFactory;

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumberList = new ArrayList<LottoNumber>();
        lottoNumberList.add(new LottoNumber(1));
        lottoNumberList.add(new LottoNumber(2));
        lottoNumberList.add(new LottoNumber(3));
        lottoNumberList.add(new LottoNumber(4));
        lottoNumberList.add(new LottoNumber(5));
        lottoNumberList.add(new LottoNumber(6));

        checkLotto = new Lotto(lottoNumberList);
    }

    @Test
    @DisplayName("로또번호 비교")
    public void makeLottoWithStringTest() {
        lottoFactory = new LottoFactory(0);
        assertThat(lottoFactory.makeLottoWithString("1,2,3,4,5,6")).isEqualTo(checkLotto);
    }

    @Test
    @DisplayName("로또 구매 개수 테스트")
    public void buyPriceTest() {
        lottoFactory = new LottoFactory(14000);
        assertThat(lottoFactory.buyQuantity()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 살 금액이 아닌 금액 테스트")
    public void buyPriceTest2() {
        assertThatThrownBy(() -> {
            lottoFactory = new LottoFactory(900);
            int quantity = lottoFactory.buyQuantity();
        }).isInstanceOf(RuntimeException.class);

    }
}
