package lotto.domain;

import lotto.exception.LottoExceptionMessage;
import org.junit.jupiter.api.DisplayName;
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
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketTest {
    private static final LottoTicketMaker LOTTO_TICKET_RANDOM_MAKER = new LottoTicketRandomMaker();

    @DisplayName("로또 생성 테스트")
    @ParameterizedTest
    @MethodSource("makeOfTicketValidData")
    void of(List<LottoNumber> lottoNumbers) {
        LottoTicket lottoTicket = LottoTicket.of(lottoNumbers);

        List<Integer> actualLottoNumbers = lottoTicket.getNumbers();

        assertThat(actualLottoNumbers).hasSize(LottoTicketMaker.DEFAULT_LOTTO_NUMBER_COUNT);
        assertThat(actualLottoNumbers.stream()
                .filter(number -> number > LottoNumber.MAX_VALUE || number < LottoNumber.MIN_VALUE)
                .findAny()).isEmpty();
    }

    private static Stream<Arguments> makeOfTicketValidData() {
        return Stream.of(
                Arguments.of(Arrays.asList(LottoNumber.of(1), LottoNumber.of(23), LottoNumber.of(41)
                        , LottoNumber.of(21), LottoNumber.of(3), LottoNumber.of(17))),
                Arguments.of(Arrays.asList(LottoNumber.of(7), LottoNumber.of(14), LottoNumber.of(15)
                        , LottoNumber.of(9), LottoNumber.of(42), LottoNumber.of(38)))
        );
    }

    @DisplayName("로또 수동 번호 오입력 테스트")
    @ParameterizedTest
    @MethodSource("makeOfTicketInvalidData")
    void of_ticket_invalid_input(List<LottoNumber> lottoNumbers) {
        String expectedExceptionMessage = LottoExceptionMessage.INVALID_LOTTO_NUMBER_COUNT;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(lottoNumbers))
                .withMessage(expectedExceptionMessage);
    }

    private static Stream<Arguments> makeOfTicketInvalidData() {
        return Stream.of(
                Arguments.of(Arrays.asList(LottoNumber.of(3), LottoNumber.of(3), LottoNumber.of(3)))
        );
    }

    @DisplayName("로또 당첨 번호 일치 개수 테스트")
    @ParameterizedTest
    @MethodSource("makeWinningLottoData")
    void getMatchCountWith(List<LottoNumber> selectLottoNumber, List<LottoNumber> winningLotto) {
        LottoTicket lottoTicket = LottoTicket.of(selectLottoNumber);
        long matchCount = lottoTicket.getMatchCountWith(winningLotto);

        List<Integer> originLottoNumbers = lottoTicket.getNumbers();
        List<Integer> copiedLottoNumbers = new ArrayList<>(originLottoNumbers);

        copiedLottoNumbers.removeAll(winningLotto.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList()));

        int expectedMatchCount = originLottoNumbers.size() - copiedLottoNumbers.size();

        assertThat(matchCount).isEqualTo(expectedMatchCount);
    }

    private static Stream<Arguments> makeWinningLottoData() {
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

        return Arguments.of(
                Arrays.asList(LottoNumber.of(1), LottoNumber.of(23), LottoNumber.of(41)
                        , LottoNumber.of(21), LottoNumber.of(3), LottoNumber.of(17))
                , winningLotto);
    }

    @DisplayName("LottoTicket에 특정 로또 번호가 존재하는지 확인 테스트")
    @ParameterizedTest
    @MethodSource("makeGetMatchWithData")
    void getMatchWith(String lottoNumberInput, int Number, boolean isMatch) {
        LottoTicketMaker lottoTicketMaker = new LottoTicketOneSelectMaker(lottoNumberInput);
        List<LottoTicket> lottoTickets = lottoTicketMaker.create(BuyCount.from(1));

        LottoTicket testLottoTicket = lottoTickets.get(0);
        LottoNumber lottoNumber = LottoNumber.of(Number);

        assertThat(testLottoTicket.getMatchWith(lottoNumber)).isEqualTo(isMatch);
    }

    private static Stream<Arguments> makeGetMatchWithData() {
        return Stream.of(
                Arguments.of("1,3,5,7,9,11", 3, true),
                Arguments.of("21,10,25,41,9,33", 1, false),
                Arguments.of("44,16,23,2,45,41", 45, true),
                Arguments.of("2,4,8,16,32,1", 17, false)
        );
    }
}
