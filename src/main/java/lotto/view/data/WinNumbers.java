package lotto.view.data;

public class WinNumbers {
    private String winNumbers;
    private int bonusWinNumber;
    
    public WinNumbers(String winNumbers, int bonusWinNumber) {
        this.winNumbers = winNumbers;
        this.bonusWinNumber = bonusWinNumber;
    }
    
    public String getWinNumbers() {
        return winNumbers;
    }
    
    public int getBonusWinNumber() {
        return bonusWinNumber;
    }
}
