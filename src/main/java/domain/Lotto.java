package domain;

import java.util.List;

public class Lotto {
    List<LottoNumber> lottoNumber;

    public Lotto(List<String> input) {
        try {
            validate(input);
        } catch (Exception e) {
            throw e;
        }

        setLottoNumber(input);
    }

    void setLottoNumber(List<String> input) {
        input.forEach(it -> lottoNumber.add(new LottoNumber(LottoUtil.stringToInteger(it))));
    }

    void validate(List<String> input) {
        // 자릿수체크
        if (input.size() != 6)
            throw new IllegalArgumentException("Lotto 숫자는 6개씩 입력가능합니다.");
    }
}
