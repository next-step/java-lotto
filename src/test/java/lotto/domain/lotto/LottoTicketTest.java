package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 6})
    void 여러개의_로또로_로또_티켓을_생성한다(int size) {
        Set<LottoNumber> lottoNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toSet());
        Lotto lotto = Lotto.from(lottoNumbers);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0 ; i < size; i++) {
            lottos.add(lotto);
        }
        LottoTicket lottoTicket = new LottoTicket(lottos);
        assertThat(lottoTicket.lottoCount()).isEqualTo(size);
    }

    @Test
    void 로또_티켓은_로또가_1개_이상일_때만_생성할_수_있다() {
        assertThatThrownBy(() -> new LottoTicket(null))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoTicket(new ArrayList<>()))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
