package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumber {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<LottoNumber> LOTTO_NUMBER_POOL;

    private int lottoNumber;

    static {
        LOTTO_NUMBER_POOL =
                Stream.iterate(LOTTO_START_NUMBER, number -> number + 1)
                .limit(LOTTO_END_NUMBER)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private LottoNumber(int lottoNumber) {
        validation(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validation(int lottoNumber) {
        if(lottoNumber < LOTTO_START_NUMBER || lottoNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("로또번호는 1~45의 숫자를 생성해주세요.");
        }
    }

    public static Lotto createLotto() {
        List<LottoNumber> lottoNumberList = LOTTO_NUMBER_POOL;
        Collections.shuffle(lottoNumberList);

        return new Lotto(lottoNumberList.stream().limit(LOTTO_NUMBER_COUNT).collect(Collectors.toList()));
    }

    public static LottoNumber of(String number) {
        return new LottoNumber(Integer.parseInt(number));
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
