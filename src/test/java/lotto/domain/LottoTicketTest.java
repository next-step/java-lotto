package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static lotto.domain.LottoTicket.PICKED_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {
    private static LottoTicket lottoTicket;

    @BeforeAll
    static void beforeAll() {
        lottoTicket = new LottoTicket();
    }

    @DisplayName("로또번호 6개 생성 테스트")
    @Test
    public void makeRandomNumbersTest() {
        List<LottoNumber> result = lottoTicket.getPickedNumbers();
        int size = result.size();
        assertThat(size).isEqualTo(PICKED_NUMBERS_SIZE);
    }

    @DisplayName("로또번호 오름차순 정렬 테스트")
    @Test
    public void sortLottoNumbersTest() {
        List<LottoNumber> lottoNumbers = LottoNumber.of(Arrays.asList(6, 5, 4, 3, 2, 1));
        List<LottoNumber> reverseLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(reverseLottoNumbers);
        lottoTicket = new LottoTicket(lottoNumbers);
        assertThat(lottoTicket.getPickedNumbers()).isEqualTo(lottoNumbers);
    }


    @DisplayName("로또번호 중복숫자 테스트")
    @Test
    public void LottoTicketDuplicatedTest() {
        List<LottoNumber> lottoNumbers = LottoNumber.of(Arrays.asList(5, 5, 4, 3, 2, 1));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(lottoNumbers));
    }
}