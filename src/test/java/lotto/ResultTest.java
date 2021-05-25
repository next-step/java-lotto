package lotto;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.entity.LottoList;
import lotto.domain.entity.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    private LottoList lottoList;
    private Result result;

    @BeforeEach
    public void setUp() {
        result = new Result(new Lotto(new Number(10), new Number(12), new Number(23), new Number(44), new Number(26), new Number(28)));
    }

    @Test
    @DisplayName("일치하는 숫자에 따라 당첨금을 확인한다. 1등 한장")
    public void 당첨금_확인_1등() {
        lottoList = new LottoList(new Lotto(
                new Number(10), new Number(12), new Number(23), new Number(44), new Number(26), new Number(28)) // 1등 - 1개
        );
        result.confirm(lottoList);
        assertThat(result.winnings()).isEqualTo(new BigDecimal("2000000000"));
    }

    @Test
    @DisplayName("일치하는 숫자에 따라 당첨금을 확인한다. 1등 한장, 2등 한장")
    public void 당첨금_확인_1등_2등() {
        lottoList = new LottoList(new Lotto(new Number(10), new Number(12), new Number(23), new Number(44), new Number(26), new Number(28)) // 1등
                , new Lotto(new Number(11), new Number(23), new Number(12), new Number(44), new Number(26), new Number(28)) // 2등 - 1개
        );
        result.confirm(lottoList);
        assertThat(result.winnings()).isEqualTo(new BigDecimal("2001500000"));
    }

    @Test
    @DisplayName("로또 구매 리스트에 대한 총 수익률을 구한다. case1: 천원 내고 오천원 당첨")
    public void 총_수익률_구하기_1() {
        lottoList = new LottoList(new Lotto(
                new Number(10), new Number(12), new Number(23), new Number(13), new Number(14), new Number(15)) // 4등 - 1개
        );
        result.confirm(lottoList);
        assertThat(result.profitRate()).isEqualTo("5.00");
    }

    @Test
    @DisplayName("로또 구매 리스트에 대한 총 수익률을 구한다. case2: 이천원 내고 오천원 당첨")
    public void 총_수익률_구하기_2() {
        lottoList = new LottoList(new Lotto(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)) // 꽝
                , new Lotto(new Number(10), new Number(12), new Number(23), new Number(13), new Number(14), new Number(15)) // 4등 - 1개
        );
        result.confirm(lottoList);
        assertThat(result.profitRate()).isEqualTo("2.50");
    }
}
