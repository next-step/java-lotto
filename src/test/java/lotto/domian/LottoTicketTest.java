package lotto.domian;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.util.LottoGenerate;
import lotto.util.LottoUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTicketTest {

    private List<LottoNumber> testNumberList;

    @BeforeEach
    void setUp() {
        testNumberList = new ArrayList<>();
        testNumberList.add(new LottoNumber(3));
        testNumberList.add(new LottoNumber(15));
        testNumberList.add(new LottoNumber(17));
        testNumberList.add(new LottoNumber(26));
        testNumberList.add(new LottoNumber(31));
        testNumberList.add(new LottoNumber(41));
    }

    @DisplayName("LottoTicket 객체 정상 생성 테스트")
    @Test
    public void lottoTicket_객체_생성_테스트() {
        LottoTicket lotto = new LottoTicket(LottoGenerate.initAutoLottoNumbers());
        LottoTicket lotto1 = new LottoTicket(LottoGenerate.initAutoLottoNumbers());
        LottoTicket lotto2 = new LottoTicket(LottoGenerate.initAutoLottoNumbers());

        assertAll("LottoTicket size == 6",
                () -> assertEquals(lotto.getLottoNumbers().size(), 6),
                () -> assertEquals(lotto1.getLottoNumbers().size(), 6),
                () -> assertEquals(lotto2.getLottoNumbers().size(), 6)
        );
    }

    @DisplayName("LottoTicket 정답 테스트, 로또와 정답 매치 카운트를 응답한다.")
    @ParameterizedTest
    @CsvSource(value = {"3, 15, 17, 24, 25, 27:3", "3, 15, 17, 24, 25, 26:4", "3, 15, 17, 24, 31, 26:5", "3, 15, 17, 41, 31, 26:6"}, delimiterString = ":")
    public void lottoTicket_정답_테스트(String resultNumList, String matchCount) {

        LottoTicket lottoTicket = new LottoTicket(testNumberList);

        List<LottoNumber> resultNumberList = LottoGenerate.initLottoNumbers(resultNumList);

        assertEquals(lottoTicket.matchLottoNumberCount(resultNumberList), Integer.parseInt(matchCount));
    }

    @DisplayName("LottoTicket 보너스볼 소유 여부를 응답한다.")
    @ParameterizedTest
    @CsvSource(value = {"3:true", "4:false", "41:true"}, delimiterString = ":")
    public void lottoTicket_보너스볼_소유_테스트(int bonusNum, Boolean hasBonus) {

        LottoTicket lottoTicket = new LottoTicket(testNumberList);

        assertEquals(lottoTicket.hasBonusBall(new LottoNumber(bonusNum)), hasBonus);
    }

    @DisplayName("LottoTicket 숫자가 6개 이상이면 에러를 응답한다.")
    @Test
    public void lottoTicket_리스트_크기_에러_테스트() {

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(15));
        lottoNumbers.add(new LottoNumber(17));
        lottoNumbers.add(new LottoNumber(26));
        lottoNumbers.add(new LottoNumber(31));
        lottoNumbers.add(new LottoNumber(41));
        lottoNumbers.add(new LottoNumber(45));

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LottoTicket 숫자 안에 중복값이 있으면 에러를 응답한다.")
    @Test
    public void lottoTicket_중복_숫자_에러_테스트() {

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(15));
        lottoNumbers.add(new LottoNumber(17));
        lottoNumbers.add(new LottoNumber(26));
        lottoNumbers.add(new LottoNumber(41));
        lottoNumbers.add(new LottoNumber(41));

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
