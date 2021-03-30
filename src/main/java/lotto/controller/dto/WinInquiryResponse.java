package lotto.controller.dto;

import java.util.List;

public class WinInquiryResponse {

    private final double totalReturnRate;
    private final List<WinStatistic> winStatisticList;

    public WinInquiryResponse(double totalReturnRate, List<WinStatistic> winStatisticList) {
        this.totalReturnRate = totalReturnRate;
        this.winStatisticList = winStatisticList;
    }

    public double getTotalReturnRate() {
        return totalReturnRate;
    }

    public List<WinStatistic> getWinStatisticList() {
        return winStatisticList;
    }
}
