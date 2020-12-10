package step4.VO;

import step4.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoNumbers {
    private final List<LottoNumber> manualLottoNumbers;

    public ManualLottoNumbers(String manualLottoNumbersString) {
        this.manualLottoNumbers = changeStringToList(manualLottoNumbersString);
    }

    private List<LottoNumber> changeStringToList(String manualLottoNumbersString) {
        List<LottoNumber> numberList = new ArrayList<>();
        String[] numbersStringList = manualLottoNumbersString.split(", ");

        validate(numbersStringList);
        for (String numberString: numbersStringList) {
            numberList.add(new LottoNumber(Integer.parseInt(numberString)));
        }

        return numberList;
    }

    private void validate(String[] numbersStringList) {
        if (numbersStringList.length < LottoGenerator.lottoSize) {
            throw new IllegalArgumentException("수동 로또가 정확히 입력되지 않았습니다.");
        }
    }

    public List<LottoNumber> getManualLottoNumbers() {
        return this.manualLottoNumbers;
    }
}
