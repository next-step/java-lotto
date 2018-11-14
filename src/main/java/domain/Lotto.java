package domain;

import domain.wrapper.LottoNo;
import utils.LottoGenerator;
import utils.StringUtils;

import java.util.List;

public class Lotto {
    public static final int LOTTO_CHOICE_CNT = 6;

    private List<Integer> numbers;
    private List<LottoNo> lottoNumbers;

    public Lotto() {
        this(LottoGenerator.generateNumberList(LOTTO_CHOICE_CNT));
    }

    public Lotto(int number) {
        this(LottoGenerator.generateNumberList(number));
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

//    public Lotto(List<LottoNo> lottoNumbers) {
//        this.lottoNumbers = lottoNumbers;
//    }
    public Lotto(String lottoStringNumber) {
        this.numbers = StringUtils.convertStrToNum(lottoStringNumber);
    }

    public int getCombineCount(Lotto lastLotto) {
        if (lastLotto == null) {
            return 0;
        }
        return (int) numbers.stream().filter(obj -> lastLotto.isContains(obj)).count();
    }

    protected boolean isContains(Integer number) {
        return numbers.contains(number);
    }

    public int getNumCount() {
        return numbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
