package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    List<LottoNumber> lotto;

    public Lotto() {
        List<Integer> lottoNumbers = RandomLotto.pickLotto();
        this.lotto = new ArrayList<>();
        for (Integer lottoNumber : lottoNumbers) {
            lotto.add(new LottoNumber(lottoNumber));
        }
    }

    public Lotto(String manualLotto) {
        this.lotto = new ArrayList<>();
        List<Integer> lottoNumbers = convertManualLotto(splitManualLotto(manualLotto));
        for (Integer lottoNumber : lottoNumbers) {
            lotto.add(new LottoNumber(lottoNumber));
        }
    }

    public List<LottoNumber> getLottoNumber() {
        return lotto;
    }

    public List<Integer> getLottoNumberList() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lotto) {
            lottoNumbers.add(lottoNumber.getLottoNumber());
        }
        return lottoNumbers;
    }

    private String[] splitManualLotto(String manualLotto) {
        return manualLotto.split(",");
    }

    private List<Integer> convertManualLotto(String[] manualLotto) {
        List<Integer> numbers = new ArrayList<>();
        for (String winningNumber : manualLotto) {
            numbers.add(Integer.parseInt(winningNumber));
        }
        return numbers;
    }
}
