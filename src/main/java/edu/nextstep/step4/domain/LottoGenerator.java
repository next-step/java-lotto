package edu.nextstep.step4.domain;

import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-30 01:10
 */
public interface LottoGenerator {
    List<Lotto> generate(List<String> manualLottos);
}
