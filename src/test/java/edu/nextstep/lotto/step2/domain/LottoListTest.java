package edu.nextstep.lotto.step2.domain;

import edu.nextstep.lotto.step2.vo.LottoNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoListTest {

    private static LottoList lottoList;
    private static int purchaseAmount;
    private static WinningList winningList;

    @BeforeAll
    static void create_before_all() {
        purchaseAmount = 14000;
        lottoList = new LottoList(purchaseAmount);
        winningList = new WinningList("1,2,3,4,5,6");
    }

    @DisplayName("로또 목록 생성 테스트")
    @Test
    void create() {
        assertThat(lottoList).isNotNull();
        assertThat(lottoList.getLottoList().size()).isEqualTo(purchaseAmount / LottoList.LOTTO_PRICE);
    }

    @DisplayName("당첨 개수 테스트")
    @Test
    void match_result() {
        assertThat(lottoList.getMatchResult(winningList, 3)).isGreaterThanOrEqualTo(0);
    }

    @DisplayName("당첨 개수 테스트 (테스트 값 고정)")
    @Test
    void match_result_again() {
        LottoNumber lottoNumber1 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber2 = new LottoNumber(Arrays.asList(4, 5, 6, 7, 8, 9));

        LottoList lottoList = new LottoList(Arrays.asList(lottoNumber1, lottoNumber2));

        assertThat(lottoList.getMatchResult(winningList, 6)).isEqualTo(1);
        assertThat(lottoList.getMatchResult(winningList, 3)).isEqualTo(1);
    }

    @DisplayName("수익률 테스트")
    @Test
    void rate() {
        assertThat(lottoList.getRate(winningList, 14000)).isGreaterThanOrEqualTo(0);
    }

    @DisplayName("수익률 테스트 (테스트 값 고정)")
    @Test
    void rate_again() {
        LottoNumber lottoNumber1 = new LottoNumber(Arrays.asList(4, 5, 6, 7, 8, 9));
        LottoNumber lottoNumber2 = new LottoNumber(Arrays.asList(10, 11, 12, 13, 14, 15));

        LottoList lottoList = new LottoList(Arrays.asList(lottoNumber1, lottoNumber2));

        assertThat(lottoList.getRate(winningList, 5000)).isEqualTo(1);
    }
}