package step2.domain;

import step2.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeLottoFactory {
    public static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_START_NUMBER_VALUE = 1;
    private static final int LOTTO_LAST_NUMBER_VALUE = 45;
    private static final int LOTTO_NUMBER = 6;

    private List<Integer> allLottoNumber = makeAllLottoNumber();
    int buyPrice;

    public MakeLottoFactory(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public List<Integer> makeAllLottoNumber() {
        List<Integer> lottoAllNumberList = new ArrayList<>();
        for (int i = LOTTO_START_NUMBER_VALUE; i <= LOTTO_LAST_NUMBER_VALUE; i++) {
            lottoAllNumberList.add(i);
        }
        return lottoAllNumberList;
    }

    public List<Lotto> lottoRandomList() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < buyQuantity(); i++) {
            lottoList.add(lottoRandom());
        }
        return lottoList;
    }

    public Lotto lottoRandom() {
        Collections.shuffle(allLottoNumber);
        ArrayList<Integer> getRandomNumberList = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER; i++) {
            getRandomNumberList.add(allLottoNumber.get(i));
        }
        Collections.sort(getRandomNumberList);
        return new Lotto(getRandomNumberList);
    }

    public Lotto makeLottoWithString(String lottoNumbers) {
        ArrayList<Integer> lottoNumber = new ArrayList<>();
        StringSplit stringSplit = new StringSplit(lottoNumbers);
        String[] lottoNumberArray = stringSplit.splitWithDelimeter();
        for (String numberValue:lottoNumberArray) {
            lottoNumber.add(StringUtil.stringToInt(numberValue));
        }
        return new Lotto(lottoNumber);
    }

    public int buyQuantity() {
        return buyPrice / LOTTO_PRICE;
    }
}
