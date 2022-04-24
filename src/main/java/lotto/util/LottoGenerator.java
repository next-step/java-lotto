package lotto.util;

import lotto.Lotto;
import lotto.LottoNumber;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoGenerator {

    private static final int LOTTO_COUNT = 6;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int PRICE_PER_LOTTO = 1_000;

    private final List<LottoNumber> LOTTO_Number_SET = new ArrayList<>();

    public LottoGenerator() {
        for (int i = 1; i <= MAXIMUM_LOTTO_NUMBER; i++) {
            LOTTO_Number_SET.add(new LottoNumber(i));
        }
    }

    public List<Lotto> generateLotteries(int purchaseAmount) {
        List<Lotto> lotteries = new ArrayList<>();

        int autoGeneratedCount = calculateTotalCount(purchaseAmount);

        for (int i = 0; i < autoGeneratedCount; i++) {
            shuffle(LOTTO_Number_SET);

            lotteries.add(LOTTO_Number_SET
                    .subList(0, LOTTO_COUNT)
                    .stream()
                    .collect(collectingAndThen(toList(), Lotto::new)));
        }

        return lotteries;
    }

    private int calculateTotalCount(int purchaseAmount) {
        return purchaseAmount / PRICE_PER_LOTTO;
    }

    public Lotto generateDirectlyLotto(String[] lottoNumberString) {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (String lottoNumber : lottoNumberString) {
            lottoNumberList.add(new LottoNumber(lottoNumber));
        }
        return new Lotto(lottoNumberList);
    }
}
