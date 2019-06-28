package edu.nextstep.step4.domain;

import edu.nextstep.step4.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-28 17:10
 */
class WinInfoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(
                Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6)));
    }

    @DisplayName("순위가 맞는지 확인")
    @Test
    void isRank() {
        Map<Lotto, Rank> winInfoMap = new HashMap<>();
        winInfoMap.put(lotto, Rank.SIX);
        WinInfo winInfo = new WinInfo(winInfoMap);

        assertThat(winInfo.isRank(lotto, Rank.SIX)).isTrue();
    }
}