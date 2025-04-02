package model;

import model.lotto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {
    private WinningLotto winningLotto;
    private Price price;

    @BeforeEach
    public void init() {
        winningLotto = new WinningLotto(new Lotto("1, 2, 3, 4, 5, 6"), new LottoNumber(40));
        price = new Price(1000);
    }

    @Test
    @DisplayName("구매한 로또가 전부 일치하면 2,000,00%의 수익이 난다")
    public void totalProfitTest1() {
        List<Lotto> lottos = new ArrayList<>(List.of(new Lotto("1, 2, 3, 4, 5, 6")));
        LottoResult result = LottoResult.of(winningLotto, new Lottos(lottos), price);
        assertEquals(result.getTotalProfitPercent(), 2000000.00);
    }

    @Test
    @DisplayName("구매한 로또가 전부 일치하지 않으면 0.00%의 수익이 난다")
    public void totalProfitTest2() {
        List<Lotto> lottos = new ArrayList<>(List.of(new Lotto("10, 11, 12, 13, 14, 15")));
        LottoResult result = LottoResult.of(winningLotto, new Lottos(lottos), price);
        assertEquals(result.getTotalProfitPercent(), 0.00);
    }
}
