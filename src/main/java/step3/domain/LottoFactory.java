package step3.domain;

import step2.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    public static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER = 6;
    private static final List<LottoNumber> ALL_LOTTO_NUMBER = makeAllLottoNumber();

    public static List<LottoNumber> makeAllLottoNumber() {
        List<LottoNumber> lottoAllNumberList = new ArrayList<>();
        for (int number = LottoNumber.LOTTO_START_NUMBER_VALUE; number <= LottoNumber.LOTTO_LAST_NUMBER_VALUE; number++) {
            lottoAllNumberList.add(new LottoNumber(number));
        }
        return lottoAllNumberList;
    }

    private int buyPrice;

    public LottoFactory(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public List<Lotto> makeLottoRandomList() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < buyQuantity(); i++) {
            lottoList.add(makeLottoRandom());
        }
        return lottoList;
    }

    public Lotto makeLottoRandom() {
        Collections.shuffle(ALL_LOTTO_NUMBER);
        List getRandomNumberList = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER; i++) {
            getRandomNumberList.add(ALL_LOTTO_NUMBER.get(i));
        }
        sortLotto(getRandomNumberList);
        return new Lotto(getRandomNumberList);
    }

    public void sortLotto(List lottoNumberList) {
        Collections.sort(lottoNumberList);
    }

    public Lotto makeLottoWithString(String lottoNumbers) {
        List<LottoNumber> lottoNumber = new ArrayList<>();
        String[] lottoNumberArray = StringSplit.splitWithDelimiter(lottoNumbers);
        if (lottoNumberArray.length != LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또번호는 6개입니다.");
        }

        for (String numberValue : lottoNumberArray) {
            lottoNumber.add(new LottoNumber(StringUtil.stringToInt(numberValue)));
        }
        return new Lotto(lottoNumber);
    }

    public int buyQuantity() {
        if (buyPrice / LOTTO_PRICE > 0) {
            return buyPrice / LOTTO_PRICE;
        }
        throw new RuntimeException("구매금액은 1000원 이상으로 입력해주세요");
    }
}
