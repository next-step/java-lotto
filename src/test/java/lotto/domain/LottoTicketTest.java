package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketTest {
    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
    }

    @Test
    public void create() {
        assertThat(new LottoTicket(lottoNumbers)).isEqualTo(new LottoTicket(lottoNumbers));
    }

    @Test
    public void createLessThan6LottoNumbers() {
        lottoNumbers = lottoNumbers.stream().limit(5).collect(Collectors.toList());

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(lottoNumbers));
    }

    @Test
    public void createMoreThan6LottoNumbers() {
        lottoNumbers = new ArrayList<>(lottoNumbers);
        lottoNumbers.add(LottoNumber.of(7));

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(lottoNumbers));
    }

    @Test
    public void createDuplicateLottoNumbers() {
        lottoNumbers = lottoNumbers.stream().limit(5).collect(Collectors.toList());
        lottoNumbers.add(LottoNumber.of(5));

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(lottoNumbers));
    }

    @Test
    public void matchingLottoNumbersCount() {
        final LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        final LottoTicket winningTicket = new LottoTicket(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(23),
                LottoNumber.of(3),
                LottoNumber.of(42),
                LottoNumber.of(5),
                LottoNumber.of(19)
        ));

        assertThat(lottoTicket.matchingLottoNumbersCount(winningTicket)).isEqualTo(3);
    }
}
