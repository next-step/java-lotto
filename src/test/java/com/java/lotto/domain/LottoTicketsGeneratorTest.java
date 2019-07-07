package com.java.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsGeneratorTest {
    int LOTTO_PRICE = 10000;

    @Test
    @DisplayName("입력한 숫자 만큼 자동으로 로또 티켓 생성")
    void automaticTicketsGenerator() {
        LottoPurchase lottoPurchase = new LottoPurchase(10000, new ArrayList<>());
        List<LottoTicket> tickets = LottoTicketsGenerator.automaticTicketsGenerator(lottoPurchase);
        assertThat(tickets.size()).isEqualTo(lottoPurchase.getCountOfLotto());
    }
}
