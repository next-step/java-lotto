package controller;

import domain.LottoInfo;
import domain.LottoNumbers;
import domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoControllerTest {

    private final String NUMBER_DELIMITER = ", ";

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
        for (int number = 1; number <= 45; number++) {
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

    @Test
    @DisplayName("빈 값 입력 검증 기능")
    void checkEmptyString() {
        String emptyString = "";

        controller = new LottoController();

        assertThrows(IllegalArgumentException.class,
                () -> controller.checkLottoNumberValidate(emptyString.split(NUMBER_DELIMITER)));
    }

    @Test
    @DisplayName("정답 로또 번호 숫자 검증 기능(6개)")
    void checkNumberLength() {
        String wrongLength = "1, 2, 3, 4";

        controller = new LottoController();

        assertThrows(IllegalArgumentException.class,
                () -> controller.checkLottoNumberValidate(wrongLength.split(NUMBER_DELIMITER)));
    }

    @ParameterizedTest
    @DisplayName("정답 로또 범위 체크 기능")
    @CsvSource(value = {
            "0, 2, 3, 4, 5, 6",
            "1, 2, 3, 4, 5, 46",
    }, delimiter = ':')
    void checkLottoRange(String wrongValue) {
        controller = new LottoController();
        assertThrows(IllegalArgumentException.class,
                () -> controller.checkLottoNumberValidate(wrongValue.split(NUMBER_DELIMITER)));
    }

    @ParameterizedTest
    @DisplayName("단위 금액보다 구매 금액이 작을 경우 구매 불가 체크 기능")
    @CsvSource(value = {"0", "500", "999"})
    void checkLottoLowerPrice(String wrongValue) {
        controller = new LottoController();
        assertThrows(IllegalArgumentException.class,
                () -> controller.checkLottoNumberValidate(wrongValue.split(NUMBER_DELIMITER)));
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 단위 금액이 아닌 경우 체크 기능")
    @CsvSource(value = {"1100", "1111", "11001"})
    void checkLottoWrongPrice(String wrongValue) {
        controller = new LottoController();
        assertThrows(IllegalArgumentException.class,
                () -> controller.checkLottoNumberValidate(wrongValue.split(NUMBER_DELIMITER)));
    }

    @ParameterizedTest
    @DisplayName("보너스 번호의 범위가 1 ~ 45가 아닌 경우 체크 기능")
    @CsvSource(value = {"0", "46"})
    void checkBonusRange(int bonusNumber) {
        controller = new LottoController();
        assertThrows(IllegalArgumentException.class,
                () -> controller.checkLottoRange(bonusNumber));
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 정답로또번호와 중복되는지 체크 기능")
    @CsvSource(value = "1, 2, 3, 4, 5, 6: 6", delimiter = ':')
    void checkBonusDuplicate(String lottoNumbers, int bonusNumber) {
        controller = new LottoController();
        assertThrows(IllegalArgumentException.class,
                () -> controller.checkBonusDuplicate(lottoNumbers.split(NUMBER_DELIMITER), bonusNumber));
    }

    @Test
    @DisplayName("로또 구매 금액보다 수동 로또 구매 개수가 클 경우 체크 기능")
    void checkManualLottoQuantity() {
        int lottoQuantity = 5;
        int manualQuantity = 6;

        controller = new LottoController();

        assertThrows(IllegalArgumentException.class,
                () -> controller.checkManualQuantity(lottoQuantity, manualQuantity));
    }

    @Test
    @DisplayName("자동 로또 개수 계산 기능")
    void calculateAutoQuantity() {
        int lottoQuantity = 5;
        int manualQuantity = 3;

        controller = new LottoController();

        assertThat(controller.calculateAutoQuantity(lottoQuantity, manualQuantity))
                .isEqualTo(lottoQuantity - manualQuantity);
    }

}
