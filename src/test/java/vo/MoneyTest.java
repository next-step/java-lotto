package vo;


import org.junit.Test;

public class MoneyTest {
    @Test(expected = IllegalArgumentException.class)
    public void 입력한_금액이_1000원_미만이면_exception(){
        new Money(900);
    }
}