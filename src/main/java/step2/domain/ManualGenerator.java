package step2.domain;

import java.util.List;

public class ManualGenerator implements LottoNumberGenerator {
    private final List<List<Integer>> manualLottoNumberInput;

    public ManualGenerator(List<List<Integer>> manualLottoNumberInput) {
        this.manualLottoNumberInput = manualLottoNumberInput;
    }
    public LottoNumber create() {
        isPossibleCreate();
        List<Integer> inputNumber = manualLottoNumberInput.remove(0);
        return new LottoNumber(inputNumber);
    }

    private void isPossibleCreate() {
        if (manualLottoNumberInput.size() < 1) {
            throw new IndexOutOfBoundsException("더이상 수동입력 로또번호를 생성할 수 없습니다.");
        }
    }
}
