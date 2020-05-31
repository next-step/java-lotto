package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {

    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        List<LottoTicket> lottoTicketBoxes = LottoTicketFactory.createAutoLottoTickets(2);
        lottoTicketBoxes.add(LottoTicketFactory.createManualLottoTicket("1, 2, 3, 4, 5, 6"));
        lottoTicketBoxes.add(LottoTicketFactory.createManualLottoTicket("7, 8, 9, 10, 11, 12"));

        this.lottoTickets = LottoTickets.newInstance(lottoTicketBoxes);
    }

    @DisplayName("로또 번호 리스트가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLottoNumbersIfLottoNumbersIsNull() {
        assertThatThrownBy(() -> LottoTickets.newInstance(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLottoNumbersIfLottoNumberIsNull() {
        assertThatThrownBy(() -> {
            List<LottoTicket> lottoNumbers = Arrays.asList(
                    LottoTicketFactory.createManualLottoTicket("1, 2, 3, 4, 5, 6"),
                    null
            );
            LottoTickets.newInstance(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 묶음 객체를 생성할 수 있다.")
    @Test
    void canCreateLottoNumbers() {
        LottoTickets newInstance = LottoTickets.newInstance();
        assertThat(newInstance).isInstanceOf(LottoTickets.class);
        assertThat(newInstance.getCount()).isZero();

        assertThat(this.lottoTickets).isInstanceOf(LottoTickets.class);
        assertThat(this.lottoTickets.getCount()).isEqualTo(4);
    }

    @DisplayName("로또 번호 묶음을 추가할 수 있다.")
    @Test
    void canAddAll() {
        int beforeCount = this.lottoTickets.getCount();

        List<LottoTicket> addLottoNumbers =LottoTicketFactory.createAutoLottoTickets(2);
        this.lottoTickets.addAll(LottoTicketFactory.createAutoLottoTickets(2));

        assertThat(beforeCount + addLottoNumbers.size()).isEqualTo(this.lottoTickets.getCount());
    }

    @DisplayName("로또 번호 개수를 얻을 수 있다.")
    @Test
    void canGetCount() {
        assertThat(this.lottoTickets.getCount()).isEqualTo(4);
    }

    @DisplayName("생성 유형별 개수를 얻을 수 있다.")
    @Test
    void canGetCountByCreationType() {
        assertThat(this.lottoTickets.getCountByCreationType(CreationType.MANUAL)).isEqualTo(2);
        assertThat(this.lottoTickets.getCountByCreationType(CreationType.AUTO)).isEqualTo(2);
        assertThat(this.lottoTickets.getCountByCreationType(CreationType.WIN)).isZero();
    }

    @DisplayName("List로 변환할 수 있다.")
    @Test
    void canGetToList() {
        List<LottoTicket> list = this.lottoTickets.toList();
        assertThat(list).isInstanceOf(List.class);
    }

    @DisplayName("객체를 복사할 수 있다.")
    @Test
    void canGetClone() {
        LottoTickets clone = this.lottoTickets.clone();
        assertThat(this.lottoTickets).isNotEqualTo(clone);
    }

    @DisplayName("로또 당첨 결과를 얻을 수 있다.")
    @Test
    void canCalculateMatchCount() {
        LottoTicket winLottoTicket = LottoTicketFactory.createManualLottoTicket("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = LottoNumber.newBonusNumber(7, winLottoTicket);
        LottoMatchResult lottoMatchResult = this.lottoTickets.calculateMatchCount(winLottoTicket, bonusNumber);

        assertThat(lottoMatchResult).isInstanceOf(LottoMatchResult.class);
    }
}
