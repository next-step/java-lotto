package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.LottoShopFactory;
import lotto.domain.LottoWallet;
import lotto.domain.MoneyWallet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShopTest {

    @DisplayName("원하는 개수만큼의 임시 로또 티켓을 배정한다.")
    @Test
    void createLottoTicketAsYouWant() {
        int money = 1000;
        LottoShop lottoShop = LottoShop.from(MoneyWallet.of(money), LottoShopFactory.of(Collections.emptyList()));
        LottoWallet lottoWallet = lottoShop.purchase();
        assertThat(lottoWallet.totalTicketCount()).isEqualTo(1);
    }

}
