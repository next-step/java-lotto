package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:45:FIRST",
            "7,2,3,4,5,6:1:SECOND",
            "7,2,3,4,5,6:45:THIRD",
            "7,8,3,4,5,6:45:FOURTH",
            "7,8,9,4,5,6:45:FIFTH",
            "7,8,9,10,5,6:45:LOSE",
            "7,8,9,10,11,12:45:LOSE",
            "7,8,9,10,11,12:45:LOSE"
    }, delimiter = ':')
    @DisplayName("등수 조회")
    void rank(String winningNumbers, String bonusNumber, String rankName) {
        // given
        Set<LottoNumber> lottoNumberList = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        Set<LottoNumber> lottoNumberSet = Arrays.stream(winningNumbers.split(",")).mapToInt(Integer::valueOf).mapToObj(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers winningLottoNumbers = new LottoNumbers(lottoNumberSet);

        // then
        assertThat(lottoTicket.rank(winningLottoNumbers, LottoNumber.of(Integer.parseInt(bonusNumber))).name()).isEqualTo(rankName);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("당첨번호와 보너스번호가 중복")
    void duplicate_winNumbersAndBonusNumber(int bonusNumber) {
        // given
        Set<LottoNumber> lottoNumberList = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        Set<LottoNumber> winNumberList = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers winNumbers = new LottoNumbers(winNumberList);

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoTicket.rank(winNumbers, LottoNumber.of(bonusNumber)))
                .withMessageMatching("보너스 번호와 당첨번호가 중복됩니다.");
    }
}