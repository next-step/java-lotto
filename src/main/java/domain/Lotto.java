package domain;

import domain.wrapper.LottoNo;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_CHOICE_CNT = 6;
    private List<LottoNo> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        isLottoCount(numbers.size());

        lottoNumbers = new ArrayList<>();
        for(Integer num : numbers){
            LottoNo lottoNo = LottoNo.getLottoNo(num);
            isDuplication(lottoNo);
            lottoNumbers.add(lottoNo);
        }
    }

    private void isDuplication(LottoNo lottoNo) {
        if(isContains(lottoNo) ){
            throw new RuntimeException("중복입니다.");
        }
    }

    private void isLottoCount(Integer numbers) {
        if(numbers != LOTTO_CHOICE_CNT){
            throw new RuntimeException("로또번호 "+LOTTO_CHOICE_CNT+"개를 선택해주세요.");
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
        return lottoNumbers.stream().anyMatch(num-> num.equalsNumber(number));
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
