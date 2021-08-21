package step2;

import java.util.List;

public class Ticket {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int TOTAL_NUMBER_COUNT = 6;
    private List<Integer> lottoNumbers;

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void saveLottoNumbers(List<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != TOTAL_NUMBER_COUNT) {
            throw new IllegalArgumentException("입력된 숫자의 갯수가 6개가 아닙니다.");
        }

        lottoNumbers.forEach(number -> {
            if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
                throw new IllegalArgumentException("입력된 숫자의 범위를 벗어났습니다.");
            }
        });
    }

}
