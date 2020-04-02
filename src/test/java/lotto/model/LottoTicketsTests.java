package lotto.model;

import lotto.model.*;
import lotto.model.wrapper.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("로또 여러 장 테스트")
public class LottoTicketsTests {

    private List<LottoTicket> lottoTickets = new ArrayList<>();

    @BeforeEach
    void init() {
        lottoTickets = Arrays.asList(
                LottoTicket.newInstance(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)
                ))),
                LottoTicket.newInstance(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(36), LottoNumber.of(41), LottoNumber.of(45)
                ))),
                LottoTicket.newInstance(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(19), LottoNumber.of(20)
                ))),
                LottoTicket.newInstance(new HashSet<>(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(33)
                )))
        );
    }

    @DisplayName("로또 여러 장 생성 테스트")
    @Test
    public void generateLottoTicketsTest() {
        assertThatCode(() -> new LottoTickets(lottoTickets)).doesNotThrowAnyException();
    }

    @DisplayName("로또 결과 테스트")
    @Test
    public void checkAllTest() {
        LottoTickets lottoTickets = new LottoTickets(this.lottoTickets);
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.newInstance(convertToLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(33));

        LottoResults expectedResults = LottoResults.create(Arrays.asList(LottoResult.SIX, LottoResult.THREE, LottoResult.FOUR, LottoResult.FIVE_WITH_BONUS));

        assertThat(lottoTickets.checkAll(winningLottoTicket)).isEqualTo(expectedResults);
    }

    @DisplayName("로또 갯수 테스트")
    @Test
    public void sizeTest() {
        LottoTickets lottoTickets = new LottoTickets(this.lottoTickets);
        assertThat(lottoTickets.size()).isEqualTo(this.lottoTickets.size());
    }

    private static Set<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }
}
