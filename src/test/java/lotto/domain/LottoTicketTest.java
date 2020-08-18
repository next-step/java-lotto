package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    private static final LottoTicketMaker LOTTO_TICKET_RANDOM_MAKER = new LottoTicketRandomMaker();

    @DisplayName("로또 번호 랜덤 생성 테스트")
    @Test
    void create() {
        LottoTicket lottoTicket = LottoTicket.create(LOTTO_TICKET_RANDOM_MAKER);
        List<Integer> lottoNumbers = lottoTicket.getNumbers();

        assertThat(lottoNumbers).hasSize(LottoTicketMaker.DEFAULT_LOTTO_NUMBER_COUNT);
        assertThat(lottoNumbers.stream()
                .filter(number -> number > LottoNumber.MAX_VALUE || number < LottoNumber.MIN_VALUE)
                .findAny()).isEmpty();
    }

    @DisplayName("로또 번호 고정 생성 테스트")
    @ParameterizedTest
    @MethodSource("makeSelectNumber")
    void create_tickets_number_select(String selectedLottoNumber, List<Integer> lottoNumbers) {
        LottoTicket lottoTicket = LottoTicket.create(new LottoTicketSelectMaker(selectedLottoNumber));

        assertThat(lottoTicket.getNumbers()).containsExactlyElementsOf(lottoNumbers);
    }

    private static Stream<Arguments> makeSelectNumber() {
        return Stream.of(
                Arguments.of("1,3,4,5,6", Arrays.asList(1, 3, 4, 5, 6)),
                Arguments.of("23,1,5,30,41", Arrays.asList(23, 1, 5, 30, 41)),
                Arguments.of("27,7,17,37,14,24", Arrays.asList(27, 7, 17, 37, 14, 24))
        );
    }

    @DisplayName("로또 당첨 번호 일치 개수 테스트")
    @ParameterizedTest
    @MethodSource("makeWinningLotto")
    void getMatchCountWith(List<LottoNumber> winningLotto) {
        LottoTicket lottoTicket = LottoTicket.create(LOTTO_TICKET_RANDOM_MAKER);
        int matchCount = lottoTicket.getMatchCountWith(winningLotto);

        List<Integer> originLottoNumbers = lottoTicket.getNumbers();
        List<Integer> copiedLottoNumbers = new ArrayList<>(originLottoNumbers);

        copiedLottoNumbers.removeAll(winningLotto.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList()));

        int expectedMatchCount = originLottoNumbers.size() - copiedLottoNumbers.size();

        assertThat(matchCount).isEqualTo(expectedMatchCount);
    }

    private static Stream<Arguments> makeWinningLotto() {
        return Stream.iterate(0, i -> i++)
                .limit(5)
                .map(i -> makeWinningLottoRandom());
    }

    private static Arguments makeWinningLottoRandom() {
        Random random = new Random();
        List<LottoNumber> winningLotto = new ArrayList<>();

        Stream.iterate(0, i -> i++)
                .limit(6)
                .forEach(i -> winningLotto.add(LottoNumber.of(random.nextInt(45) + 1)));

        return Arguments.of(winningLotto);
    }
}
