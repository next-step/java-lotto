package lotto.domain;

import lotto.domian.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreTest {

    private List<Lotto> lottoList = new ArrayList<>();
    private LottoBundle lottoBundle;

    @BeforeEach
    public void setUp() {
        List<LottoNumber> lottoNumber1 = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));

        List<LottoNumber> lottoNumber2 = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(6)
                , new LottoNumber(7));
        Lotto lotto1 = new Lotto(lottoNumber1);
        Lotto lotto2 = new Lotto(lottoNumber2);

        lottoList.add(lotto1);
        lottoList.add(lotto2);
        lottoBundle = new LottoBundle(lottoList);
    }

    @DisplayName("구매한 로또들 중에서 당첨된 것들을 뽑을 수 있다.")
    @Test
    public void pickRank_AmongLottoBundle_pickRanks() {
        String winNumberString = "1, 2, 3, 4, 5, 6";
        WinNumber winNumber = new WinNumber(Store.pickWinNumber(winNumberString));

        Record record = Store.extractRecord(lottoBundle, winNumber);
        Assertions.assertThat(record.getRecord().get(Rank.FIRST)).isEqualTo(1);
        Assertions.assertThat(record.getRecord().get(Rank.SECOND)).isEqualTo(1);
    }

    @DisplayName("금액 단위만큼 로또를 주문할 수 있다.")
    @Test
    public void order_MakeLottoDependsOnMoney_MakeLotto() {
        Money money = new Money(4000);
        int count = money.amount() / 1000;

        LottoBundle bundle = Store.order(money);
        Assertions.assertThat(bundle.unfoldLottoBundle().size()).isEqualTo(count);
    }

    @DisplayName("로또 당첨 번호는 숫자 형태여야 한다.")
    @Test
    public void pickWinNumber_NumberMustBeNumeric_IfNotThrowException() {
        String winNumber = "1, 2, 3, 4, a, 5";

        Assertions.assertThatThrownBy(() -> Store.pickWinNumber(winNumber))
                .isInstanceOf(NumberFormatException.class);
    }

}
