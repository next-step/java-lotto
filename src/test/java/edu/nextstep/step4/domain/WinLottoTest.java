package edu.nextstep.step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-28 15:02
 */
public class WinLottoTest {
    private Lotto lotto;


    @BeforeEach
    void setUp() {
        lotto = new Lotto(
                new HashSet<>(Arrays.asList(
                        Number.of(1),
                        Number.of(2),
                        Number.of(3),
                        Number.of(4),
                        Number.of(5),
                        Number.of(6)
                )));
    }

    @DisplayName("전달된 Lotto객체와 당첨번호 몇개가 일치하는지 확인")
    @Test
    void matchCount() {
        Lotto sourceLotto = new Lotto(
            new HashSet<>(Arrays.asList(
                Number.of(1),
                Number.of(2),
                Number.of(3),
                Number.of(4),
                Number.of(5),
                Number.of(6)
            )));
        assertThat(lotto.stream()
                .filter(compareSourceNumber -> sourceLotto.contains(compareSourceNumber))
                .collect(Collectors.toList())
                .size()).isEqualTo(6);
    }
}
