package lotto.domian;

import lotto.domain.LottoGame;
import lotto.util.LottoUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGameTest {

    private List<Integer> testNumberList;

    @BeforeEach
    void setUp() {
        testNumberList = new ArrayList<>();
        testNumberList.add(3);
        testNumberList.add(15);
        testNumberList.add(17);
        testNumberList.add(26);
        testNumberList.add(31);
        testNumberList.add(41);
    }

    @DisplayName("LottoGame 객체 정상 생성 테스트")
    @Test
    public void lottoGame_객체_생성_테스트() {
        LottoGame lotto = new LottoGame(LottoUtils.initLottoNumbers());
        LottoGame lotto1 = new LottoGame(LottoUtils.initLottoNumbers());
        LottoGame lotto2 = new LottoGame(LottoUtils.initLottoNumbers());

        assertAll("LottoGame size == 6",
                () -> assertEquals(lotto.getLottoNumber().size(), 6),
                () -> assertEquals(lotto1.getLottoNumber().size(), 6),
                () -> assertEquals(lotto2.getLottoNumber().size(), 6)
        );
    }

    @DisplayName("LottoGame 정답 테스트, 로또와 정답 매치 카운트를 응답한다.")
    @ParameterizedTest
    @CsvSource(value = {"3, 15, 17, 24, 25, 27:3", "3, 15, 17, 24, 25, 26:4", "3, 15, 17, 24, 31, 26:5", "3, 15, 17, 41, 31, 26:6"}, delimiterString = ":")
    public void lottoGame_정답_테스트(String resultNumList, String matchCount) {

        LottoGame lotto = new LottoGame(testNumberList);

        List<Integer> resultNumberList = LottoUtils.lottoResultNumberList(resultNumList);

        assertEquals(lotto.matchLottoNumberCount(resultNumberList), Integer.parseInt(matchCount));
    }
}
