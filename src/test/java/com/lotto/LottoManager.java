package com.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LottoManager {
    private static final String PRICE_PATTERN = "^[0-9]+$";
    private final Pattern pattern = Pattern.compile(PRICE_PATTERN);

    public LottoGroup issue(String price) {
        if(!pattern.matcher(price).find()) {
            throw new IllegalArgumentException("price value is wrong.");
        }

        int totalCount = Integer.parseInt(price)/Lotto.UNIT_PRICE;
        List<Lotto> lottoList = createLottoList(totalCount);

        return new LottoGroup(lottoList);
    }

    private List<Lotto> createLottoList(int totalCount) {
        List<Lotto> lottoList = new ArrayList<>();

        for(int i = 0; i< totalCount; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generate());
            lottoList.add(lotto);
        }
        return lottoList;
    }
}
