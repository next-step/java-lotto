package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.dto.RankDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCalculationTest {

    private static final int price = 14000;
    private static final int expectedLotto = 14;
    private List<Lotto> oldLottos;


    @BeforeEach
    void makeLottos() {
        List<LottoNumber> lottoManualOne = Arrays.stream("8, 21, 23, 41, 42, 43"
                .replace(" ", "")
                .split(","))
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        List<LottoNumber> lottoManualTwo = Arrays.stream("3, 5, 11, 16, 32, 38"
                .replace(" ", "")
                .split(","))
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        List<LottoNumber> lottoManualThree = Arrays.stream("7, 11, 16, 35, 36, 44"
                .replace(" ", "")
                .split(","))
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        oldLottos = new ArrayList<>();

        oldLottos.add(new Lotto(lottoManualOne));
        oldLottos.add(new Lotto(lottoManualTwo));
        oldLottos.add(new Lotto(lottoManualThree));
    }

    @DisplayName("로또를_몇개_살수_있는지_테스트")
    @Test
    void countLottoesTest() {
        Money money = new Money(price);
        LottoCalculation lottoCalculation = new LottoCalculation(money);
        assertThat(lottoCalculation.getLottosCalculation()).isEqualTo(expectedLotto);
    }

    @DisplayName("로또_수동_자동_구매_테스트")
    @Test
    void purchaseLottoTest() {
        Money money = new Money("14000");
        LottoCalculation lottoCalculation = new LottoCalculation(new Money("14000"));
        lottoCalculation.getPurchaseLottos(oldLottos,money);
        assertThat(lottoCalculation.getLottos().calculateNumberOfLottosAutomatical(oldLottos.size(), money)).isEqualTo(11);

    }

    @DisplayName("이전_당첨_번호_확인_테스트")
    @Test
    void makeWinningLottoNumberTest() {
        LottoCalculation lottoCalculation = new LottoCalculation(new Money("14000"));
        Winning winning = new Winning("1,2,3,4,5,6", new LottoNumber(7));
        assertThat(winning).isNotNull();
    }

    @DisplayName("RankDto에_담기는_값이_랭크에_대한_결과값_테스트")
    @Test
    void makeRankResultTest() {
        Money money = new Money("14000");
        LottoCalculation lottoCalculation = new LottoCalculation(money);
        lottoCalculation.getPurchaseLottos(oldLottos, money);
        Winning winning = new Winning("1,2,3,4,5,6", new LottoNumber(7));
        RankResult rankResult = new RankResult(lottoCalculation.getLotto(), winning);
        RankDTO rankDto = new RankDTO(rankResult, money);
        assertThat(rankDto).isNotNull();
    }

    @DisplayName("수동_로또_입력에_대한_결과값_테스트")
    @Test
    void makeLottoTicketTest() {
        assertAll(
            () -> assertThat(new LottoTicketManual("3", 14)),
            () -> assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicketManual("15", 14))
        );
    }
}
