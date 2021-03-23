package step2.dto;

import java.util.List;

public class LottoDTO {

    public static class NormalLottoDTO {
        private final List<Integer> numbers;

        public NormalLottoDTO(List<Integer> numbers) {
            this.numbers = numbers;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }
    }

    public static class WinningLottoDTO {
        private final List<Integer> numbers;
        private final int bonusNumber;

        public WinningLottoDTO(List<Integer> numbers, int bonusNumber) {
            this.numbers = numbers;
            this.bonusNumber = bonusNumber;
        }

        public List<Integer> getNumbers() {
            return this.numbers;
        }

        public int getBonusNumber() {
            return this.bonusNumber;
        }
    }
}
