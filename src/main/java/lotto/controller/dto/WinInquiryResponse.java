package lotto.controller.dto;

import java.util.List;

public class WinInquiryResponse {

    private final List<WinStatistic> winStatisticList;
    private final double totalReturnRate;

    public WinInquiryResponse(List<WinStatistic> winStatisticList, double totalReturnRate) {
        this.winStatisticList = winStatisticList;
        this.totalReturnRate = totalReturnRate;
    }

    public List<WinStatistic> getWinStatisticList() {
        return winStatisticList;
    }

    public double getTotalReturnRate() {
        return totalReturnRate;
    }
}
