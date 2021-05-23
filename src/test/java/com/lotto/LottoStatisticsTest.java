package com.lotto;

import com.lotto.domain.LottoReward;
import com.lotto.domain.LottoStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {
    private LottoStatistics lottoStatistics;

    @BeforeEach
    void init() {
        //given
        LottoReward reward1 = LottoReward.generateReward(3);
        LottoReward reward2 = LottoReward.generateReward(4);
        LottoReward reward3 = LottoReward.generateReward(5);
        LottoReward reward4 = LottoReward.generateReward(0);
        LottoReward reward5 = LottoReward.generateReward(1);
        List<LottoReward> lottoRewards = new ArrayList<>(Arrays.asList(reward1, reward2, reward3, reward4, reward5));

        //when
        lottoStatistics = LottoStatistics.createLottoStatistics(lottoRewards);
    }

    @DisplayName("로또 통계 객체 생성")
    @Test
    void createLottoStatistics() {
        assertThat(lottoStatistics.size()).isEqualTo(4);
    }

    @DisplayName("로또 통계 총 보상금")
    @Test
    void totalReward() {
        assertThat(lottoStatistics.totalReward()).isEqualTo(1555000);
    }

    @DisplayName("로또 통계 수익률")
    @Test
    void yield() {
        assertThat(lottoStatistics.yield()).isEqualTo(311.00);
    }
}
