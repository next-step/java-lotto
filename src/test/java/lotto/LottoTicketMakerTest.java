package lotto;

import lotto.model.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketMakerTest {



    @Test
    void createNumList() {
        List<Integer> numList = LottoTicketMaker.createNumList();
        assertThat(numList.size()).isEqualTo(45);
        assertThat(numList.stream().min(Comparator.comparingInt(o -> o)).get()).isEqualTo(1);
        assertThat(numList.stream().max(Comparator.comparingInt(o -> o)).get()).isEqualTo(45);
    }

    @Test
    void issue() {
        LottoTicket lottoTicketA = LottoTicketMaker.issue();
        assertThat(lottoTicketA.lotto.stream()
                .distinct()
                .collect(Collectors.toList()).size())
                .isEqualTo(6);

        LottoTicket lottoTicketB = LottoTicketMaker.issue();
        LottoTicket lottoTicketC = LottoTicketMaker.issue();
        assertThat(lottoTicketB.lotto.containsAll(lottoTicketC.lotto)).isFalse();
    }
}