package domain;

import java.util.List;

public class LottoNumbers {
    public final List<LottoNumber> numbers;

    public LottoNumbers() {
        this.numbers = LottoNumberGenerator.generateLottoNumbers();
    }

    public LottoNumbers(List<String> input) {
        validate(input);
        this.numbers = LottoNumberGenerator.generateLottoNumbers(input);
    }

    public void createAutoLottoNumbers() {
    }

    public void createManualLottoNumbers() {
    }

    public LottoNumbers(String strInput) {
        List<String> input = LottoUtil.stringSplitToList(strInput);
        validate(input);
        this.numbers = LottoNumberGenerator.generateLottoNumbers(input);
    }

    private void validate(List<String> input) {
        if (input.size() != 6)
            throw new IllegalArgumentException("로또 번호는 6개씩 입력 가능 합니다.");
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
