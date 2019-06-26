package lotto.view;

public class WinNumbers {
    private String winNumbers;
    private int bonasWinNumber;
    
    WinNumbers(String winNumbers, int bonasWinNumber) {
        this.winNumbers = winNumbers;
        this.bonasWinNumber = bonasWinNumber;
    }
    
    public String getWinNumbers() {
        return winNumbers;
    }
    
    public int getBonasWinNumber() {
        return bonasWinNumber;
    }
}
