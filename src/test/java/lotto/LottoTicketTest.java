package lotto;

import lotto.domain.LottoTicket;
import lotto.strategy.AutoLottoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("로또번호는 6개로 생성된다.")
    void generateLottoNumbers_6자제한(){
        assertThat(LottoTicket.generateLottoNumbers(new AutoLottoStrategy()).getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨번호와 매칭되는 수를 반환한다.")
    void matchLottoNumbers(){
       List<Integer> winningNumbers = Arrays.asList(1, 1, 1, 1, 1, 1);
       assertThat(new LottoTicket(winningNumbers).matchLottoNumbers((winningNumbers))).isEqualTo(6);
    }
}
