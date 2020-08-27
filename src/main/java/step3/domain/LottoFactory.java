package step3.domain;

import step2.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    public static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER = 6;

    //다른 분의 리뷰를 살펴보던 중 final을 잘 쓸 수 있는 코드가 있어서 참고해서 사용해보았습니다.
    private static final List<LottoNumber> ALL_LOTTO_NUMBER = IntStream.rangeClosed(LottoNumber.LOTTO_START_NUMBER_VALUE, LottoNumber.LOTTO_LAST_NUMBER_VALUE)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

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
