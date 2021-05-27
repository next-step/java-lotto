package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoPurchaseServiceTest {

    private LottoPurchaseService service;

    @BeforeEach
    void setUp() {
        service = new LottoPurchaseService();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    @DisplayName("로또티켓 구입 - 구입금액 부족 시")
    void purchase_lackOfAmount(int purchaseAmount) {
        // given when
        LottoTickets lottoTickets = service.purchaseAutoTickets(LottoMoney.of(purchaseAmount));

        // then
        assertThat(lottoTickets.count()).isEqualTo(0);
    }
    
    @Test
    @DisplayName("구입금액 검증")
    void validatePurchasable() {
        // given
        LottoMoney havingAmount = LottoMoney.of(10000);
        LottoMoney purchaseAmount = LottoMoney.fromCount(14);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.validatePurchasable(havingAmount, purchaseAmount))
                .withMessageMatching("금액이 부족합니다. 보유금액과 구입금액을 확인해 주세요.");
    }

    @Test
    @DisplayName("구입금액 검증")
    void lackOfHavingAmount() {
        // given
        LottoMoney havingAmount = LottoMoney.of(500);
        LottoMoney purchaseAmount = LottoMoney.fromCount(1);

        // when then
        assertThatIllegalStateException()
                .isThrownBy(() -> service.validatePurchasable(havingAmount, purchaseAmount))
                .withMessageMatching("금액이 부족합니다. 최소 1000 원 이상의 금액을 입력해 주세요.");
    }

    @Test
    @DisplayName("수동로또 구매")
    void purchaseManualTickets() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet()));
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(lottoNumbers);
        lottoNumbersList.add(lottoNumbers);
        lottoNumbersList.add(lottoNumbers);

        LottoMoney lottoMoney = LottoMoney.fromCount(3);

        // when
        LottoTickets lottoTickets = service.purchaseManualTickets(lottoMoney, lottoNumbersList);

        // then
        assertThat(lottoTickets.count()).isEqualTo(3);
        for (LottoTicket lottoTicket : lottoTickets) {
            assertThat(lottoTicket.lottoNumbers()).isEqualTo(lottoNumbers);
        }
    }

    @Test
    @DisplayName("수동로또 구매 - 금액부족")
    void purchaseManualTickets_lackOfMoney() {
        // given
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet())));
        lottoNumbersList.add(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet())));
        lottoNumbersList.add(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet())));

        LottoMoney lottoMoney = LottoMoney.fromCount(2);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.purchaseManualTickets(lottoMoney, lottoNumbersList))
                .withMessageMatching("금액이 부족합니다. 보유금액과 구입금액을 확인해 주세요.");
    }

}