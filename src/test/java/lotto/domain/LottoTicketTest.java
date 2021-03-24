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
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
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
        lottoNumbers.add(new LottoNumber(7));

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(lottoNumbers));
    }

    @Test
    public void createDuplicateLottoNumbers() {
        lottoNumbers = lottoNumbers.stream().limit(5).collect(Collectors.toList());
        lottoNumbers.add(new LottoNumber(5));

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(lottoNumbers));
    }

    @Test
    public void matchingLottoNumbersCount() {
        final LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        final LottoTicket winningTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(23),
                new LottoNumber(3),
                new LottoNumber(42),
                new LottoNumber(5),
                new LottoNumber(19)
        ));

        assertThat(lottoTicket.matchingLottoNumbersCount(winningTicket)).isEqualTo(3);
    }
}
