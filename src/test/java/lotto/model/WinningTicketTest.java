package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningTicketTest {
    List<LottoNumber> winningNumbers = new ArrayList<>();

    @BeforeEach
    void 당첨티켓_테스트데이터() {
        winningNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @DisplayName("로또당첨 티켓 생성 테스트 (보너스 번호 중복 실패)")
    @Test
    void 당첨티켓_보너스번호_중복() {
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningTicket(new LottoTicket(winningNumbers), bonusNumber))
                .withMessageMatching("보너스 번호는 6개의 당첨번호와 같을 수 없습니다.");
    }

    @DisplayName("로또당첨 티켓 생성 테스트 (보너스번호 정상 포함)")
    @Test
    void 당첨티켓_보너스번호포함_정상() {
        LottoNumber bonusNumber = new LottoNumber(45);

        WinningTicket winningTicket = new WinningTicket(new LottoTicket(winningNumbers), bonusNumber);

        assertThat(winningTicket.getLottoNumbers().size()).isEqualTo(winningNumbers.size());
    }

    @DisplayName("구입한 로또티켓과 로또당첨 티켓과 비교(2등보너스 랭크로 테스트)")
    @Test
    void 비교_테스트() {
        LottoNumber bonusNumber = new LottoNumber(45);

        WinningTicket winningTicket = new WinningTicket(new LottoTicket(winningNumbers), bonusNumber);

        List<LottoNumber> numberList = new ArrayList<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(45)));

        Rank rank = winningTicket.match(numberList);
        assertThat(rank).isEqualTo(Rank.BONUS_RANK);
    }
}
