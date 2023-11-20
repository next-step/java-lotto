package com.fineroot.lotto.dto;

import java.util.List;

public class LottoBundleStatus {
    private final List<String> lottoBundleStatusList;

    private LottoBundleStatus(List<String> lottoBundleStatusList){
        this.lottoBundleStatusList = lottoBundleStatusList;
    }

    public static LottoBundleStatus from(List<String> lottoBundleStatusList){
        return new LottoBundleStatus(lottoBundleStatusList);
    }

    public String get(final int index){
        return lottoBundleStatusList.get(index);
    }

    public int size(){
        return lottoBundleStatusList.size();
    }
}
