package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketTest {

    @DisplayName("로또티켓 생성 테스트(6개의 번호)")
    @Test
    void 로또티켓_생성_테스트_정상() {
        int[] numArr = {1, 2, 3, 4, 5, 45};

        List<LottoNumber> numbers = Arrays.stream(numArr)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        LottoTicket lottoTicket = new LottoTicket(numbers);
        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);

    }

    @DisplayName("로또티켓 생성 테스트(6개의 번호가 아닌경우)")
    @Test
    void 로또티켓_생성_테스트_오류() {
        int[] numArr = {1, 2, 3, 4, 5};

        List<LottoNumber> numbers = Arrays.stream(numArr)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(numbers))
                .withMessageMatching("로또 번호는 6개 입니다.");

    }

    @DisplayName("로또티켓 생성 테스트(중복이 있는 경우)")
    @Test
    void 로또티켓_생성_테스트_오류_번호중복() {
        int[] numArr = {1, 1, 3, 4, 5, 6};

        List<LottoNumber> numbers = Arrays.stream(numArr)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(numbers))
                .withMessageMatching("로또번호는 중복될 수 없습니다.");

    }

    @DisplayName("로또티켓 생성 테스트(Collections.shuffle사용)")
    @Test
    void 로또티켓_생성_테스트_shuffle() {
        LottoTicket lottoTicket = LottoFactory.createAutoLottoTicket();
        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또티켓생성_당첨번호_개수_테스트")
    @Test
    void 로또티켓_당첨번호_개수() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        List<LottoNumber> numberList = new ArrayList<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)));
        int count = lottoTicket.matchLottoNumberCount(numberList);

        assertThat(count).isEqualTo(2);
    }

}
