package com.cheolhyeonpark.lotto.domain;

import com.cheolhyeonpark.lotto.domain.number.LottoTicket;
import com.cheolhyeonpark.lotto.domain.number.Number;
import com.cheolhyeonpark.lotto.domain.number.Numbers;
import com.cheolhyeonpark.lotto.domain.number.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoManagerTest {

    @Test
    void createLottoNumbers() {
        LottoTicket lottoTicket = new LottoTicket();
        LottoManager lottoManager = new LottoManager(lottoTicket);

        lottoManager.createLottoNumbers(new Count(3),
                Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 7", "1, 2, 3, 4, 5, 8"));

        assertThat(lottoTicket.size()).isEqualTo(6);
    }

    @Test
    void getGameResult() {
        LottoManager lottoManager = new LottoManager(new LottoTicket());
        lottoManager.createLottoNumbers(new Count(0),
                Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 7", "1, 2, 3, 4, 5, 8"));

        LottoResult lottoResult
                = lottoManager.getGameResult(new WinningNumbers(new Numbers("1, 2, 3, 4, 5, 6"), new Number(7)));

        assertThat(lottoResult.getCount(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getCount(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.getCount(Rank.THIRD)).isEqualTo(1);
    }
}