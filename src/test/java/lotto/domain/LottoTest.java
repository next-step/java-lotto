package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.lottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    public void initialLottoNumber() {
        this.lottoNumbers = new ArrayList<>(Arrays.asList(
                LottoNumber.lottoNumber(3), LottoNumber.lottoNumber(5), LottoNumber.lottoNumber(13)
                , LottoNumber.lottoNumber(27), LottoNumber.lottoNumber(35), LottoNumber.lottoNumber(41)));
    }

    @Test
    @DisplayName("로또 생성시 등록된 로또 번호를 조회한다.")
    void sameLottoNumbers() {
        assertThat(new Lotto(lottoNumbers).lottoNumbers())
                .hasSize(6);
    }

    @Test
    @DisplayName("로또 생성시 로또 번호의 수가 6자리가 아닐 경우 예외가 발생한다.")
    void checkLengthOfLottoNumbers() {
        lottoNumbers.add(LottoNumber.lottoNumber(45));
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 생성시 로또 번호에 중복되는 숫자가 있을 경우 예외가 발생한다.")
    void lottoNumberDuplicateException() {
        lottoNumbers.add(LottoNumber.lottoNumber(3));
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @RepeatedTest(100)
    @DisplayName("발급된 로또와 당첨 번호의 매칭된 숫자의 수를 검증한다.")
    void compareIssuedNumberWithWinningLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.automaticIssue(new ArrayList<>(lottoNumbers()), 1);

        Lotto winningNumber = new WinningLotto(new Lotto(lottoNumbers), LottoNumber.lottoNumber(7)).winningLotto();
        List<Integer> matchingCounts = lottoMachine.lottoTickets()
                .stream()
                .map(ticket -> ticket.compareNumber(winningNumber))
                .collect(Collectors.toList());

        assertThat(matchingCounts).hasSize(1);
        assertThat(matchingCounts.get(0)).isLessThanOrEqualTo(6);
        assertThat(matchingCounts.get(0)).isGreaterThanOrEqualTo(0);
    }
}
