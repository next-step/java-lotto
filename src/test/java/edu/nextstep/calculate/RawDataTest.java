package edu.nextstep.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-24 21:41
 */
public class RawDataTest {

    @DisplayName("담아둔 데이터 가져오기")
    @Test
    void getRawData() {
        RawData raw = new RawData("1,2,3");
        assertThat(raw.getRawData()).isEqualTo("1,2,3");
    }
}
