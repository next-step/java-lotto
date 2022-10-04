package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    public static final LottoNumber ONE = new LottoNumber(1);
    public static final LottoNumber TWO = new LottoNumber(2);
    public static final LottoNumber THREE = new LottoNumber(3);
    public static final LottoNumber FOUR = new LottoNumber(4);
    public static final LottoNumber FIVE = new LottoNumber(5);
    public static final LottoNumber SIX = new LottoNumber(6);
    public static final LottoNumber THIRTY = new LottoNumber(30);
    
    @Test
    @DisplayName("로또 번호 생성")
    void create() {
        assertThat(ONE).isNotNull();
    }
}