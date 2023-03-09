package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private List<LottoNumber> lottoNumber;
    private LottoRankAmount lottoRankAmount;

    public Lotto() {
        this.lottoNumber = makeLottoNumber();
    }

    // public Lotto(List<String> input, int matchCount, boolean withBonusYn) {
    // try {
    // validate(input);
    // } catch (Exception e) {
    // throw e;
    // }

    // makeLottoNumber(input);
    // lottoRankAmount = new LottoRank(matchCount, withBonusYn).lottoRankAmount;
    // }

    public LottoRankAmount getLottoRankAmount() {
        return lottoRankAmount;
    }

    List<LottoNumber> makeLottoNumber() {
        LottoNumberList lottoNumberList = new LottoNumberList();
        List<LottoNumber> newlottoNumber = lottoNumberList.getLottoNumberList();
        Collections.shuffle(newlottoNumber);

        newlottoNumber = newlottoNumber.subList(0, 6);
        Collections.sort(newlottoNumber, Comparator.comparingInt(LottoNumber::getLottoNumber));

        return newlottoNumber;
    }

    List<LottoNumber> makeLottoNumber(List<String> input) {
        List<LottoNumber> newLottoNumber = new ArrayList<LottoNumber>();
        input.forEach(it -> {
            newLottoNumber.add(new LottoNumber(LottoUtil.stringToInteger(it)));
        });

        return newLottoNumber;
    }

    void validate(List<String> input) {
        if (input.size() != 6)
            throw new IllegalArgumentException("Lotto 숫자는 6개씩 입력가능합니다.");
    }

    public List<LottoNumber> getLottoNumber() {
        return this.lottoNumber;
    }

}
