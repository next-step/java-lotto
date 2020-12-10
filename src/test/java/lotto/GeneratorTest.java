package lotto;

import lotto.domain.Generator;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorTest {

    private Generator generator;

    @BeforeEach
    public void setUp() {
        generator = new Generator();
    }

    @Test
    @DisplayName("수량만큼 로또를 생성한다")
    public void generate_lotto_ticket_list() {
        List<LottoTicket> lottoTickets = generator.generateLottoTickets(3);
        assertThat(lottoTickets.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("입력받은 로또 숫자 목록으로 로또를 생성한다")
    public void generate_manual_lotto_ticket() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<List<Integer>> numbers = new ArrayList<>();
        numbers.add(numbers1);
        List<LottoTicket> lottoTickets = generator.generateManualLottoTicket(numbers);
        LottoTicket lottoTicket = lottoTickets.get(0);
        assertThat(lottoTicket.toString()).isEqualTo("[1,2,3,4,5,6]");
    }
}
