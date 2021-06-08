package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    private final int LOTTO_NUM = 14;


    @Test
    void lottoList() {
        LottoTicket lottoTicket = new LottoTicket(LOTTO_NUM);
        assertThat(lottoTicket.lottoList().size()).isEqualTo(LOTTO_NUM);
    }

    @Test
    void lottoTicket() {
        List<Lotto> lottoList = new ArrayList<>();
        Lotto lotto = new Lotto();
        lottoList.add(lotto);
        LottoTicket lottoTicket = new LottoTicket(lottoList);
        assertThat(lottoTicket.lottoList()).isEqualTo(lottoList);
    }

    @Test
    void addLotto(){
        LottoTicket lottoTicket=new LottoTicket(LOTTO_NUM);
        lottoTicket.addLotto(1);
        assertThat(lottoTicket.lottoList().size()).isEqualTo(LOTTO_NUM+1);
    }

    @Test
    void 클라이언트가_null을_입력하면_어떻게_처리할까요() {
        // given
        final LottoTicket lottoTicket = new LottoTicket(null);

        // when
        int actual = lottoTicket.getLottoSize();

        // then
        assertThat(actual).isZero();
    }

    @Test
    void 로또_마이너스_1개를_구입_할_수_있나요() {
        // given
        final LottoTicket lottoTicket = new LottoTicket(null);

        // when
        // then
        assertThatThrownBy(() -> lottoTicket.addLotto(-1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 당첨번호도_null_허용하나요() {
        // given
        final LottoTicket lottoTicket = new LottoTicket(null);

        // when
        // then
        assertThatThrownBy(() -> lottoTicket.compareWinList(null, null))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 로또티켓에서_마이너스_1번째_로또번호를_꺼낼_수_있나요() {
        // given
        final LottoTicket lottoTicket = new LottoTicket(null);

        // when
        final List<LottoNumber> actual = lottoTicket.getLottoNumWithIdx(-1);

        // then
        assertThat(actual).isEmpty();
    }

}