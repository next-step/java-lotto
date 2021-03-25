package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketTest {
    private LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers(
                Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6)
                )
        );
        bonusNumber = LottoNumber.of(7);
    }

    @Test
    public void create() {
        assertThat(new LottoTicket(lottoNumbers, bonusNumber)).isEqualTo(new LottoTicket(lottoNumbers, bonusNumber));
    }

    @Test
    public void createDuplicateLottoNumbersAndBonusNumber() {
        final LottoNumber duplicateBonusNumber = LottoNumber.of(6);

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(lottoNumbers, duplicateBonusNumber));
    }

    @Test
    public void matchingLottoNumbersCount() {
        final LottoTicket lottoTicket = new LottoTicket(lottoNumbers, bonusNumber);

        final LottoTicket winningTicket = new LottoTicket(
                new LottoNumbers(
                        Arrays.asList(
                                LottoNumber.of(1),
                                LottoNumber.of(23),
                                LottoNumber.of(3),
                                LottoNumber.of(42),
                                LottoNumber.of(5),
                                LottoNumber.of(19)
                        )
                ), bonusNumber
        );

        assertThat(lottoTicket.matchingLottoNumbersCount(winningTicket)).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"7:true", "8:false"}, delimiter = ':')
    public void sameBonusNumber(String targetBonusNumberInput, String expectedInput) {
        final LottoNumber targetBonusNumber = LottoNumber.of(Integer.parseInt(targetBonusNumberInput));
        final boolean expected = Boolean.parseBoolean(expectedInput);

        final LottoTicket lottoTicket = new LottoTicket(lottoNumbers, bonusNumber);
        final LottoTicket targetLottoTicket = new LottoTicket(lottoNumbers, targetBonusNumber);
        final boolean result = lottoTicket.sameBonusNumber(targetLottoTicket);

        assertThat(result).isEqualTo(expected);
    }
}
