package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private List<Integer> list;

    @BeforeEach
    void 초기화(){
        this.list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            this.list.add(i);
        }
    }

    @Test
    void 로또생성테스트() {
        assertThat(new Lotto(list).toString()).isEqualTo(list.toString());
    }

    @Test
    void matchWinningNumber() {
        int[] winningNums = new int[] {6,7,8,9,10,11};
        assertThat(new Lotto(list).matchWinningNumber(winningNums)).isEqualTo(1);
    }
}