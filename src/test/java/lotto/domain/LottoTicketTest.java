package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static LottoTicket lottoTicket;

    @BeforeAll
    static void beforeAll() {
        lottoTicket = new LottoTicket();
    }

    @DisplayName("로또번호 6개 생성 테스트")
    @Test
    public void makeRandomNumbersTest() {
        List<Integer> result = lottoTicket.getPickedNumbers();
        int size = result.size();
        assertThat(size).isEqualTo(LOTTO_NUMBERS_SIZE);
    }

    @DisplayName("로또번호 오름차순 정렬 테스트")
    @Test
    public void sortLottoNumbersTest() {
        lottoTicket = new LottoTicket(Arrays.asList(6, 5, 4, 3, 2, 1));
        assertThat(lottoTicket.getPickedNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}