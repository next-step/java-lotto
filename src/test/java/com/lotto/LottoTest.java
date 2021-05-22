package com.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @DisplayName("로또 생성-가격과 갯수 일치 확인")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "14000,14", "13300,13", "13800,13"})
    void 로또_생성(String price, int expected) {
        LottoManager manager = new LottoManager();
        LottoGroup lottoGroup = manager.issue(price);
        assertThat(lottoGroup.size()).isEqualTo(expected);
    }

    @DisplayName("로또 생성-가격이 음수 또는 문자 예외 확인")
    @ParameterizedTest
    @ValueSource(strings = {"-200", "price"})
    void 로또_가격_음수_또는_문자_예외(String price) {
        LottoManager manager = new LottoManager();
        assertThatThrownBy(() -> manager.issue(price)).isInstanceOf(IllegalArgumentException.class);
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

    @Test
    void 로또담청_총수익금_확인() {
        Lotto lotto1 = new Lotto(Arrays.asList(2, 5, 10, 23, 32, 35));
        Lotto lotto2 = new Lotto(Arrays.asList(2, 5, 10, 23, 32, 34));
        Lotto lotto3 = new Lotto(Arrays.asList(2, 5, 10, 23, 31, 34));
        List<Lotto> lottoList = new ArrayList<>(Arrays.asList(lotto1, lotto2, lotto3));

        LottoGroup lottoGroup = new LottoGroup(lottoList);

        int totalReward = lottoGroup.totalReward(new HashSet<>(Arrays.asList(2, 5, 10, 23, 32, 35)));

        assertThat(totalReward)
                .isEqualTo(LottoReward.SIX.reward() + LottoReward.FIVE.reward() + LottoReward.FOUR.reward());
    }
}
