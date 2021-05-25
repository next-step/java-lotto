package study.ascii92der.lotto.step3;

import java.util.*;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(String lottoString) {
        lottoNumbers = new ArrayList<>();
        String[] lottoArray = lottoString
                .replaceAll(" ", "")
                .split(",");
        validDuplicateNumber(lottoArray);

        for (String value : lottoArray) {
            lottoNumbers.add(new LottoNumber(value));
        }
    }

    public List<LottoNumber> generateNumber() {

        return lottoNumbers;
    }

    private void validDuplicateNumber(String[] lottoArray) {
        Set<String> lottoNumberSet = new HashSet<>(Arrays.asList(lottoArray));
        if (lottoNumberSet.size() != lottoArray.length) {
            throw new IllegalArgumentException("This Numbers has duplicate number");
        }
    }
}
