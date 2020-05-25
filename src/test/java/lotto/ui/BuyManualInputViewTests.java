package lotto.ui;

import lotto.domain.lotto.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BuyManualInputViewTests {
    @DisplayName("수동 입력할 로또 수를 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        assertThat(new BuyManualInputView(3)).isNotNull();
    }

    @DisplayName("수동 입력할 갯수만큼 쉼표로 구분된 문자열을 받아서 LottoTickets 객체를 생성할 수 있다.")
    @Test
    void createManualLottoTicketsTest() {
        List<String> stringInputs = Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12", "13, 14, 15, 16, 17, 18");
        BuyManualInputView buyManualInputView = new BuyManualInputView(3, stringInputs);

        LottoTickets manualLottoTickets = buyManualInputView.convertToManualLottoTickets();

        assertThat(manualLottoTickets.size()).isEqualTo(3);
    }

    @DisplayName("수동 입력할 갯수가 0개면 빈 LottoTicket 객체를 생성한다.")
    @Test
    void createEmptyLottoTicket() {
        BuyManualInputView buyManualInputView = new BuyManualInputView(0);
        LottoTickets lottoTickets = buyManualInputView.convertToManualLottoTickets();

        assertThat(lottoTickets.size()).isEqualTo(0);
    }

    @DisplayName("로또 티켓으로 전환 시 수동 입력할 갯수만큼 문자열이 입력됐는지 확인한다.")
    @Test
    void convertLottoTicketsValidation() {
        BuyManualInputView buyManualInputView = new BuyManualInputView(1, new ArrayList<>());

        assertThatThrownBy(buyManualInputView::convertToManualLottoTickets)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
