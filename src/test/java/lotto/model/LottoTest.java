package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("6자리 숫자 생성 테스트")
    void when_lotto_object_created_with_six_numbers(){
        List<Integer> numbers = makeTestNumbers();

        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @Test
    @DisplayName("")
    void print_lotto_number_test(){
        Lotto lotto = new Lotto(makeTestNumbers());

        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("Lotto 한장 당 가격 체크")
    void check_lotto_price(){
        assertThat(Lotto.LOTTO_PRICE).isEqualTo(1000);
    }

    private List<Integer> makeTestNumbers() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        return numbers;
    }

}