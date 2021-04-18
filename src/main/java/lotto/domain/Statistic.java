package lotto.domain;

import lotto.dto.InfoDto;

import java.util.*;

public class Statistic {

    // 상금
    private final int[] Winnings = {0,0,0,5000,50000,1500000,2000000000};
    double revenueRate;
    List<InfoDto> infoDtos;

    public Statistic(int purchaseAmount, Map<Long,Integer> lottoStatistic){
        infoDtos = new ArrayList<>();
        float revenue = 0;
        for(int correctNum = 3; correctNum<=6 ; correctNum++){
            int count = lottoStatistic.getOrDefault(Long.valueOf(correctNum),0);
            InfoDto infoDto = new InfoDto(correctNum,Winnings[correctNum],count);
            infoDtos.add(infoDto);
            revenue += (count*Winnings[correctNum]);
        }
        revenueRate = Math.round((revenue / purchaseAmount) * 100) / 100.0;
    }

    public double getRevenueRate() {
        return revenueRate;
    }

    public List<InfoDto> getInfoDtos() {
        return infoDtos;
    }
}
