package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class ShuffleTest {

    WholeLottoNumbers wholeLottoNumbers;
    @BeforeEach
    void setUp() {
        wholeLottoNumbers = new WholeLottoNumbers();
        wholeLottoNumbers.createNumber();
    }

    @Test
    @DisplayName("로또 생성이 잘 되는지 테스트")
    public  void lottoTest(){

    }
}