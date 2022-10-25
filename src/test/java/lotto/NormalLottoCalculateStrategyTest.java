package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NormalLottoCalculateStrategyTest {

    LottoCalculateStrategy lottoCalculateStrategy = new NormalLottoCalculateStrategy();

    @Test
    @DisplayName("로또 티켓 카운트")
    void test1() {
        // given
        Money money = new Money(1000);
        // when
        int count = lottoCalculateStrategy.countLottoTickets(money);
        // then
        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 티켓 숫자 미중복")
    void test2() {
        // given
        // when
        List<SelectedLottoNumbers> selectedLottoes = lottoCalculateStrategy.buyLottoTickets(5);
        // then
        for (int i = 0; i < selectedLottoes.size(); i++) {
            for (int j = i + 1; j < selectedLottoes.size(); j++) {
                SelectedLottoNumbers l1 = selectedLottoes.get(i);
                SelectedLottoNumbers l2 = selectedLottoes.get(j);

                int count = 0;
                for (int p = 0; p < l1.getSelectedLottoNumbers().size(); p++) {
                    LottoNumber lottoNumber1 = l1.getSelectedLottoNumbers().get(p);
                    for (int q = 0; q < l2.getSelectedLottoNumbers().size(); q++) {
                        LottoNumber lottoNumber2 = l2.getSelectedLottoNumbers().get(q);
                        if (lottoNumber1.equals(lottoNumber2)) {
                            count += 1;
                        }
                    }
                }
                assertThat(count).isLessThan(6);
            }
        }
    }

}