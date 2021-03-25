package lotto.controller.dto;

import java.util.List;

public class WinInquiryRequest {

    private final String winNumber;
    private final List<String> confirmTargetList;

    public WinInquiryRequest(String winNumber, List<String> confirmTargetList) {
        this.winNumber = winNumber;
        this.confirmTargetList = confirmTargetList;
    }

    public String getWinNumber() {
        return winNumber;
    }

    public List<String> getConfirmTargetList() {
        return confirmTargetList;
    }
}
