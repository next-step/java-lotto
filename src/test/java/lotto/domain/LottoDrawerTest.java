package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1. 구매금액이 5000원이고 총 상금이 5000원이면 수익률은 1이다.
 */
public class LottoDrawerTest {
    @Test
    void 수익률_테스트() {
        Money 구매금액 = new Money(5000);
        List<Lotto> 로또 = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto 지난주_당첨번호 = new Lotto("1, 2, 3, 7, 8, 9");

        List<Integer> 일치한_당첨번호_개수 = LottoDrawer.hitNumber(로또, 지난주_당첨번호);

        double 수익률 = LottoDrawer.calProfit(구매금액, 일치한_당첨번호_개수);
        assertEquals(수익률, 1.0);
    }

    @Test
    void 특정_수익률_테스트() {
        Money 구매금액 = new Money(14000);
        List<Lotto> 로또 = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto 지난주_당첨번호 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        List<Integer> 일치한_당첨번호_개수 = LottoDrawer.hitNumber(로또, 지난주_당첨번호);
        double 수익률 = LottoDrawer.calProfit(구매금액, 일치한_당첨번호_개수);
        assertEquals(수익률, 0.35);
    }

    @Test
    void 일치한_당첨번호_개수_테스트() {
        Lotto 첫번째_로또 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto 두번째_로또 = new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11));
        Lotto 세번쨰_로또 = new Lotto(Arrays.asList(9, 10, 11, 12, 13, 14));

        Lotto 지난주_당첨번호 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoDrawer 로또추첨기 = new LottoDrawer();
        List<Integer> 일치한_당첨번호_개수 = 로또추첨기.hitNumber(Arrays.asList(첫번째_로또, 두번째_로또, 세번쨰_로또), 지난주_당첨번호);
        assertEquals(Collections.frequency(일치한_당첨번호_개수, 6), 1);
        assertEquals(Collections.frequency(일치한_당첨번호_개수, 3), 1);
        assertEquals(Collections.frequency(일치한_당첨번호_개수, 0), 1);
    }

    @Test
    void 중복된_일치한_당첨번호_개수_테스트() {
        Lotto 첫번째_로또 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto 두번쨰_로또 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        Lotto 지난주_당첨번호 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoDrawer 로또추첨기 = new LottoDrawer();
        List<Integer> 일치한_당첨번호_개수 = 로또추첨기.hitNumber(Arrays.asList(첫번째_로또, 두번쨰_로또), 지난주_당첨번호);
        assertEquals(Collections.frequency(일치한_당첨번호_개수, 6), 2);

    }

}
