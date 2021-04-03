package lotto.controller.dto;

import java.util.List;

public class WinInquiryRequest {

    private final String winNumber;
    private final List<String> confirmTargetList;
    private final int bonusNumber;

    public WinInquiryRequest(String winNumber, List<String> confirmTargetList, int bonusNumber) {
        this.winNumber = winNumber;
        this.confirmTargetList = confirmTargetList;
        this.bonusNumber = bonusNumber;
    }

    public String getWinNumber() {
        return winNumber;
    }

    public List<String> getConfirmTargetList() {
        return confirmTargetList;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "WinInquiryRequest{" +
                "winNumber='" + winNumber + '\'' +
                ", confirmTargetList=" + confirmTargetList +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
