package com.lotto;

import com.lotto.domain.LottoGroup;
import com.lotto.domain.RequestPurchaseLotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGroupTest {
    @Test
    void createLottoGroup_생성() {
        RequestPurchaseLotto requestPurchaseLotto = new RequestPurchaseLotto();
        requestPurchaseLotto.setManualLottoCount("0");
        requestPurchaseLotto.setLottoList(new String[]{});
        requestPurchaseLotto.setTotalPrice("14000");
        LottoGroup lottoGroup = LottoGroup.createLottoGroup(requestPurchaseLotto);
        assertThat(lottoGroup.size()).isEqualTo(14);
    }
}
