package lotto.domain;

import lotto.exception.NotPositiveException;
import lotto.strategy.RandomNumberStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Purchasing {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList;

    public Purchasing(String input) {
        checkNull(input);
        checkNotPositive(input);
        int money = Integer.parseInt(input);
        lottoList = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lottoList.add(new Lotto(new RandomNumberStrategy()));
        }
    }

    private void checkNull(String input) {
        if (StringUtils.isBlank(input)) {
            throw new NotPositiveException();
        }
    }

    private static void checkNotPositive(String input) {
        if (!StringUtils.isNumeric(input)) {
            throw new NotPositiveException();
        }
        if (Integer.parseInt(input) < 0) {
            throw new NotPositiveException();
        }
    }

    public List<Long> getMatchCntList(Lotto winningLotto) {
        return lottoList.stream()
                .map(lotto -> lotto.matchCnt(winningLotto))
                .collect(Collectors.toList());
    }

    public int getLottoCnt() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
