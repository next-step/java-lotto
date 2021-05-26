package com.lotto;

import com.lotto.domain.LottoGroup;
import com.lotto.domain.ReqPurchaseLotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGroupTest {
    @Test
    void createLottoGroup_생성() {
        ReqPurchaseLotto reqPurchaseLotto = new ReqPurchaseLotto();
        reqPurchaseLotto.setManualLottoCount("0");
        reqPurchaseLotto.setLottoList(new String[]{});
        reqPurchaseLotto.setTotalPrice("14000");
        LottoGroup lottoGroup = LottoGroup.createLottoGroup(reqPurchaseLotto);
        assertThat(lottoGroup.size()).isEqualTo(14);
    }
}
