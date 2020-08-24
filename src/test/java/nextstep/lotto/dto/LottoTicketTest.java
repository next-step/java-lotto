package nextstep.lotto.dto;

import nextstep.lotto.utils.LottoNumberUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoTicketTest {

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void createLottoTicket(){
        LottoTicket lottoTicket = LottoTicket.create(LottoNumberUtil.generator());
        assertThat(lottoTicket.getLottoNumber()).hasSize(6);
    }

    @Test
    void 일치하는로또_티켓_갯수확인_TEST(){
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumber.create(1));
        lottoNumbers.add(LottoNumber.create(2));
        lottoNumbers.add(LottoNumber.create(3));
        lottoNumbers.add(LottoNumber.create(4));
        lottoNumbers.add(LottoNumber.create(5));
        lottoNumbers.add(LottoNumber.create(6));

        List<LottoNumber> winnerLotto = new ArrayList<>();
        winnerLotto.add(LottoNumber.create(1));
        winnerLotto.add(LottoNumber.create(2));
        winnerLotto.add(LottoNumber.create(3));
        winnerLotto.add(LottoNumber.create(4));
        winnerLotto.add(LottoNumber.create(5));
        winnerLotto.add(LottoNumber.create(6));


        LottoTicket ticket = LottoTicket.create(lottoNumbers);
        LottoWinnerNumbers winnerNumbers = LottoWinnerNumbers.create(winnerLotto,LottoNumber.create(7));
        assertThat(winnerNumbers.matchCount(ticket.getLottoNumber())).isEqualTo(LottoRank.FIRST);
    }
}
