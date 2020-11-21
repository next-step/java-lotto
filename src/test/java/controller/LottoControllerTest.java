package controller;

import domain.LottoInfo;
import domain.LottoNumbers;
import domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest {

    LottoController controller;

    @Test
    @DisplayName("구입 금액에 따른 로또 구매 개수 계산 기능")
    void calculateLottoQuantity() {
        int price = 14000;
        controller = new LottoController(price);
        assertThat(controller.getLottoQuantity()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 구매 개수대로 로또 자동 생성 기능")
    void makeAutoLottos() {
        int price = 5000;
        int quantity = 5;
        LottoInfo lottoInfo = LottoInfo.of(price, quantity);
        controller = new LottoController(lottoInfo);

        List<Integer> basicLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lottos lottos = controller.initLottos(quantity, basicLottoNumbers);
        assertThat(lottos.getLottos().size()).isEqualTo(quantity);
    }

    @Test
    @DisplayName("기본 로또번호 리스트 생성 기능")
    void createBasicLottoNumbers() {
        controller = new LottoController();
        List<Integer> basicLottoNumbers = controller.createBasicLottoNumbers();
        List<Integer> numbers = new ArrayList<>();
        for(int number = 1; number <= 45; number++) {
            numbers.add(number);
        }

        assertThat(basicLottoNumbers.size()).isEqualTo(45);
        assertThat(basicLottoNumbers).isEqualTo(numbers);
    }

    @Test
    @DisplayName("무작위 로또번호 섞는 기능")
    void shuffleNumbers() {
        controller = new LottoController();
        List<Integer> basicLottoNumbers = controller.createBasicLottoNumbers();
        LottoNumbers lottoNumbers = controller.shuffleNumbers(basicLottoNumbers);

        Assertions.assertThat(lottoNumbers.getNumbers().size()).isEqualTo(6);
    }
}
