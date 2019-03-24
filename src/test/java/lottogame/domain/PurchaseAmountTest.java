package lottogame.domain;

import org.junit.Test;

import static lottogame.domain.PurchaseAmount.LOTTO_PRICE;
import static org.junit.Assert.*;

public class PurchaseAmountTest {

    private PurchaseAmount purchaseAmount;

    @Test(expected = NumberFormatException.class)
    public void constructor_of_PurchaseAmount_for_null_String() {
        new PurchaseAmount(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_of_PurchaseAmount_for_empty_String() {
        new PurchaseAmount("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_of_PurchaseAmount_for_string_String() {
        new PurchaseAmount("aaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_of_PurchaseAmount_for_zero_LOTTO_PRICE_String() {
        new PurchaseAmount("0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_of_PurchaseAmount_for_smaller_than_minimum_value_String() {
        new PurchaseAmount(String.valueOf(LOTTO_PRICE - 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_of_PurchaseAmount_for_bigger_than_maximum_value_String() {
        new PurchaseAmount(String.valueOf(Long.MAX_VALUE));
    }

    @Test
    public void constructor_of_PurchaseAmount_for_LOTTO_PRICE_String() {
        long expected = LOTTO_PRICE;

        PurchaseAmount purchaseAmount = new PurchaseAmount(new String(String.valueOf(expected)));

        assertEquals(expected, purchaseAmount.getValue());
        assertEquals(expected/LOTTO_PRICE, purchaseAmount.getLottoCount());
    }

    @Test
    public void constructor_of_PurchaseAmount_for_10_times_of_LOTTO_PRICE_String() {
        long expected = LOTTO_PRICE * 10 + (LOTTO_PRICE-1);

        PurchaseAmount purchaseAmount = new PurchaseAmount(new String(String.valueOf(expected)));

        assertEquals(expected, purchaseAmount.getValue());
        assertEquals(expected/LOTTO_PRICE, purchaseAmount.getLottoCount());
    }

    @Test
    public void constructor_of_PurchaseAmount_for_maximum_value_String() {
        long expected = Long.MAX_VALUE-1;

        PurchaseAmount purchaseAmount = new PurchaseAmount(new String(String.valueOf(expected)));

        assertEquals(expected, purchaseAmount.getValue());
        assertEquals(expected/LOTTO_PRICE, purchaseAmount.getLottoCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_of_PurchaseAmount_for_0() {
        new PurchaseAmount(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_of_PurchaseAmount_for_less_than_minimum_value() {
        new PurchaseAmount(LOTTO_PRICE-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_of_PurchaseAmount_for_more_than_maximum_value() {
        new PurchaseAmount(Long.MAX_VALUE);
    }

    @Test
    public void constructor_of_PurchaseAmount_for_LOTTO_PRICE() {
        long expected = LOTTO_PRICE;

        purchaseAmount = new PurchaseAmount(expected);

        assertEquals(expected, purchaseAmount.getValue());
        assertEquals(expected/LOTTO_PRICE, purchaseAmount.getLottoCount());
    }

    @Test
    public void constructor_of_PurchaseAmount_for_10_times_of_LOTTO_PRICE() {
        long expected = LOTTO_PRICE * 10;

        purchaseAmount = new PurchaseAmount(expected);

        assertEquals(expected, purchaseAmount.getValue());
        assertEquals(expected/LOTTO_PRICE, purchaseAmount.getLottoCount());
    }

    @Test
    public void constructor_of_PurchaseAmount_for_maximum_value() {
        long expected = Long.MAX_VALUE-1;

        purchaseAmount = new PurchaseAmount(expected);

        assertEquals(expected, purchaseAmount.getValue());
        assertEquals(expected/LOTTO_PRICE, purchaseAmount.getLottoCount());
    }

    @Test
    public void getLottoCount_for_exact_value() {
        int expected = 20;

        purchaseAmount = new PurchaseAmount(20000);

        assertEquals(expected, purchaseAmount.getLottoCount());
    }

    @Test
    public void getLottoCount_for_value_has_remainder() {
        int expected = 12;

        purchaseAmount = new PurchaseAmount(12345);

        assertEquals(expected, purchaseAmount.getLottoCount());
    }
}