package com.fineroot.lotto.entity;

import com.fineroot.lotto.dto.LottoBundleStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {

    private List<Lotto> lottoList;


    private LottoBundle(int lotteryCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < lotteryCount; i++) {
            lottoList.add(Lotto.create());
        }
    }

    public static LottoBundle from(int lotteryCount) {
        return new LottoBundle(lotteryCount);
    }

    LottoBundleStatus toLottoBundleStatus() {
        return LottoBundleStatus.from(lottoList.stream().map(Lotto::toString).collect(Collectors.toList()));
    }
}
