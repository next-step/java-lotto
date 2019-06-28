package edu.nextstep.step4.domain;

import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

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
    private Number bonusNumber;


    @BeforeEach
    void setUp() {
        lotto = new Lotto(
                Arrays.asList(
                        Number.of(1),
                        Number.of(2),
                        Number.of(3),
                        Number.of(4),
                        Number.of(5),
                        Number.of(6)
                ));
        bonusNumber = Number.of(7);
    }
}
