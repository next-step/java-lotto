package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoGameConfig.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoGameConfig.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketTest {

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    private LottoTicket lottoTicket;

    private static final LottoNumber BONUS_NUMBER = new LottoNumber(11);

    @BeforeEach
    void setUp(){
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER+1).forEach(number -> lottoNumbers.add(new LottoNumber(number)));

        Collections.shuffle(lottoNumbers);
        this.lottoNumbers  = lottoNumbers.stream().limit(6).collect(Collectors.toList());

        int[] numbers = {1,2,3,4,5,6};

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        IntStream.of(numbers).forEach(num -> lottoNumbers.add(new LottoNumber(num)));
        this.lottoTicket = new LottoTicket(lottoNumbers, true);
    }

    @DisplayName("LottoTicket 랜덤 번호 생성 테스트")
    @Test
    void lottoTicketRandomNumberCreateTest(){
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers, true);
        assertThat(lottoTicket.getSortedLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName("LottoTicket 번호 오름차순으로 조회되는지 테스트")
    @Test
    void getLottoTicketSortedNumberTest(){
        //given
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers, true);

        //when
        int min = lottoTicket.getSortedLottoNumbers()
                .stream()
                .mapToInt(v -> v.getNumber())
                .min().orElseThrow(NoSuchElementException::new);

        // then
        assertThat(new LottoNumber(min)).isEqualTo(lottoTicket.getSortedLottoNumbers().get(0));
    }

    @DisplayName("일치하는 당첨번호 갯수 계산 테스트")
    @Test
    void countWinningNumbersTest(){
        int[] lastWinningNumbers = {1,2,3,7,8,9};
        List<LottoNumber> lastWinningNumberList = new ArrayList<>();
        IntStream.of(lastWinningNumbers).forEach(number -> lastWinningNumberList.add(new LottoNumber(number)));

        PrizeUnit prizeUnit = this.lottoTicket.countWinningNumbers(lastWinningNumberList, BONUS_NUMBER);

        assertThat(prizeUnit).isEqualTo(PrizeUnit.FIFTH_GRADE);

    }

    @DisplayName("최소 당첨번호 갯수 미만인 경우 0리턴 테스트")
    @Test
    void countWinningNumbersUnderMinToPrizeTest(){
        int[] lastWinningNumbers = {1,2,41,31,21,15};
        List<LottoNumber> lastWinningNumberList = new ArrayList<>();
        IntStream.of(lastWinningNumbers).forEach(number -> lastWinningNumberList.add(new LottoNumber(number)));

        PrizeUnit prizeUnit = this.lottoTicket.countWinningNumbers(lastWinningNumberList, BONUS_NUMBER);

        assertThat(prizeUnit).isEqualTo(PrizeUnit.FAIL_GRADE);

    }

    @DisplayName("보너스 번호 당첨 테스트")
    @Test
    void countWinningNumbersAndBonusTest(){
        int[] lastWinningNumbers = {1,2,3,4,5,11};

        List<LottoNumber> lastWinningNumberList = new ArrayList<>();
        IntStream.of(lastWinningNumbers).forEach(number -> lastWinningNumberList.add(new LottoNumber(number)));

        PrizeUnit prizeUnit = this.lottoTicket.countWinningNumbers(lastWinningNumberList, new LottoNumber(6));

        assertThat(prizeUnit).isEqualTo(PrizeUnit.SECOND_GRADE);

    }

    @DisplayName("로또 번호 유효성 검증(갯수)")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2,3,4,5"})
    void illegalLastWinningNumberExceptionTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {

            List<LottoNumber> lastWinningNumberList = Arrays.stream(input.split(","))
                    .map(number -> new LottoNumber(Integer.parseInt(number))).collect(Collectors.toList());

            this.lottoTicket.countWinningNumbers(lastWinningNumberList, BONUS_NUMBER);
        }).withMessageContaining(LottoErrorMessage.ILLEGAL_LOTTO_NUMBER_COUNT.getErrorMessage());
    }

    @DisplayName("보너스 번호 유효성 검증(최대 번호 초과)")
    @Test
    void illegalBonusNumberExceptionTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {

            int[] lastWinningNumbers = {1,2,3,4,5,11};
            int bonusNumber = 46;
            List<LottoNumber> lastWinningNumberList = new ArrayList<>();
            IntStream.of(lastWinningNumbers).forEach(number -> lastWinningNumberList.add(new LottoNumber(number)));

            this.lottoTicket.countWinningNumbers(lastWinningNumberList, new LottoNumber(bonusNumber));

        }).withMessageContaining(LottoErrorMessage.ILLEGAL_LOTTO_NUMBER.getErrorMessage());
    }
}
