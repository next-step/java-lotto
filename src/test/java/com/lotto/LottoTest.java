package com.lotto;

import com.lotto.controller.LottoManager;
import com.lotto.domain.Lotto;
import com.lotto.domain.LottoGroup;
import com.lotto.domain.LottoReward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    /*@DisplayName("로또 생성-가격과 갯수 일치 확인")
    @Test
    void 로또_생성() {
        LottoManager manager = new LottoManager();
        LottoGroup lottoGroup = manager.createLottoGroup(14);
        assertThat(lottoGroup.size()).isEqualTo(14);
    }

    @DisplayName("담청 성공 후 보상금 테스트")
    @Test
    void 로또번호와_담청번호_비교_결과() {
        Lotto lotto = new Lotto(Arrays.asList(2, 5, 10, 23, 32, 35));
        LottoReward lottoReward = lotto.reward(new HashSet<>(Arrays.asList(2, 5, 10, 23, 32, 34)));

        assertThat(lottoReward).isEqualTo(LottoReward.FIVE);
        assertThat(lottoReward.reward()).isEqualTo(LottoReward.FIVE.reward());
    }

    @DisplayName("담청 실패 후 보상금 테스트")
    @Test
    void 로또번호와_담청번호_비교_결과2() {
        Lotto lotto = new Lotto(Arrays.asList(2, 5, 10, 23, 32, 35));
        LottoReward lottoReward = lotto.reward(new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 7)));

        assertThat(lottoReward).isEqualTo(LottoReward.NOTHING);
        assertThat(lottoReward.reward()).isEqualTo(LottoReward.NOTHING.reward());
    }

    @DisplayName("로또담청 총수익금 확인")
    @Test
    void 로또담청_총수익금_확인() {
        Lotto lotto1 = new Lotto(Arrays.asList(2, 5, 10, 23, 32, 35)); // SIX
        Lotto lotto2 = new Lotto(Arrays.asList(2, 5, 10, 23, 32, 34)); // FIVE
        Lotto lotto3 = new Lotto(Arrays.asList(2, 5, 10, 23, 31, 34)); // FOUR
        List<Lotto> lottoList = new ArrayList<>(Arrays.asList(lotto1, lotto2, lotto3));

        LottoGroup lottoGroup = new LottoGroup(lottoList);

        //when
        int totalReward = lottoGroup.totalReward(new HashSet<>(Arrays.asList(2, 5, 10, 23, 32, 35)));

        //then
        assertThat(totalReward)
                .isEqualTo(LottoReward.SIX.reward() + LottoReward.FIVE.reward() + LottoReward.FOUR.reward());
    }

    @DisplayName("로똠담청 총수익률 확인")
    @Test
    void 로또담청_총수익률_확인() {
        Lotto lotto1 = new Lotto(Arrays.asList(2, 5, 10, 23, 32, 35));
        Lotto lotto2 = new Lotto(Arrays.asList(2, 5, 10, 23, 32, 34));
        Lotto lotto3 = new Lotto(Arrays.asList(2, 5, 10, 23, 31, 34));
        List<Lotto> lottoList = new ArrayList<>(Arrays.asList(lotto1, lotto2, lotto3));

        LottoGroup lottoGroup = new LottoGroup(lottoList);

        //when
        double yield = lottoGroup.yield(new HashSet<>(Arrays.asList(1, 2, 5, 10, 11, 23)));

        //then
        assertThat(yield).isEqualTo(50.0);
    }*/
}
