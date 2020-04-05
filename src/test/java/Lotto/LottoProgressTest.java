package Lotto;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoProgressTest {

    private Amount amount;
    private int quantity;

    private LottoProgress lottoProgress;
    private LottoPaper lottoPaper;
    private LottoBundle lottoBundle;
    List<Integer> prizeList;

    @BeforeEach
    public void setUp() {
        amount = new Amount("14000");

        lottoProgress = new LottoProgress();
        lottoPaper = new LottoPaper();

        quantity = lottoProgress.amountToQuantity(amount);

        lottoBundle = new LottoBundle(quantity);

        prizeList.add(2);
        prizeList.add(3);
        prizeList.add(4);
        prizeList.add(5);
        prizeList.add(6);
        prizeList.add(7);
    }

    @Test
    public void amountToQuantity() {
        assertThat(lottoProgress.amountToQuantity(amount)).isEqualTo(14);
    }


}
