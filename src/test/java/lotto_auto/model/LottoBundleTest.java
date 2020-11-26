package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoBundleTest {

    @DisplayName("로또 티켓 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1:2:3",
            "3:4:7",
            "5:2:7",
            "4:1:5",
    }, delimiter = ':')
    public void createLottoTest(int manual, int auto, int expected) {

        List<LottoTicket> manualLottoTickets = IntStream.range(0, manual)
                .boxed()
                .map(item -> new LottoTicket())
                .collect(Collectors.toList());

        List<LottoTicket> autoLottoTickets = IntStream.range(0, auto)
                .boxed()
                .map(item -> new LottoTicket())
                .collect(Collectors.toList());

        List<LottoTicket> all = new ArrayList<>();
        all.addAll(manualLottoTickets);
        all.addAll(autoLottoTickets);

        LottoBundle lottoBundle = new LottoBundle(all, autoLottoTickets.size(), manualLottoTickets.size());
        assertAll(() -> assertThat(lottoBundle.getTicketCount()).isEqualTo(expected),
                () -> assertThat(lottoBundle.getManual()).isEqualTo(manualLottoTickets.size()),
                () -> assertThat(lottoBundle.getAuto()).isEqualTo(autoLottoTickets.size())
        );
    }

    @DisplayName("export Ticket isNotNull")
    @Test
    public void exportTicketIsNotNullTest() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket());
        lottoTickets.add(new LottoTicket());
        LottoBundle lottoBundle = new LottoBundle(lottoTickets, 1, 1);
        assertThat(lottoBundle.export()).isNotNull();
    }

    @DisplayName("로또 추첨 중복 테스트")
    @Test
    public void test() {

        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(1));
        lottoNumberList.add(new LottoNumber(2));
        lottoNumberList.add(new LottoNumber(3));
        lottoNumberList.add(new LottoNumber(4));
        lottoNumberList.add(new LottoNumber(5));
        lottoNumberList.add(new LottoNumber(6));
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);

        LottoNumber lottoNumber = new LottoNumber(6);
        assertThatThrownBy(
                () -> {
                    List<LottoTicket> lottoTickets = new ArrayList<>();
                    lottoTickets.add(new LottoTicket());
                    lottoTickets.add(new LottoTicket());
                    LottoBundle lottoBundle = new LottoBundle(lottoTickets, 1, 1);
                    lottoBundle.draw(lottoNumbers, lottoNumber);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
