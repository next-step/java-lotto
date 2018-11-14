package domain;

import domain.wrapper.LottoNo;
import utils.LottoGenerator;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int LOTTO_CHOICE_CNT = 6;
    private List<LottoNo> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        lottoNumbers = new ArrayList<>();
        for(Integer num : numbers){
            lottoNumbers.add(new LottoNo(num));
        }
    }

    public Lotto(String lottoStringNumber) {
        this.lottoNumbers = StringUtils.convertStrLottoToNum(lottoStringNumber);
    }

    public int getCombineCount(Lotto lastLotto) {
        if (lastLotto == null) {
            return 0;
        }
        return (int) lottoNumbers.stream().filter(obj -> lastLotto.isContains(obj)).count();
    }
    public boolean isContains(LottoNo number) {
        return lottoNumbers.stream().filter(num-> num.getNumber() == number.getNumber()).count() > 0;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
