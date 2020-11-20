package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLottoNumberTest {
    private List<Integer> myNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        myNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("내 로또 번호 갯수 유효성")
    @Test
    void validSizeOfMyNumber() {
        assertThat(MyLottoNumber.setShuffleNumber(myNumbers)).size().isEqualTo(6);
    }
}
