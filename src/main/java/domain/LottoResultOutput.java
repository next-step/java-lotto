package domain;

public enum LottoResultOutput {
    RIGHT_3(3, "개 일치 (5000원)- "),
    RIGHT_4(4, "개 일치 (50000원)- "),
    RIGHT_5(5, "개 일치 (1500000원)- "),
    RIGHT_6(6, "개 일치 (2000000000원)- ");

    private final int correctCount;
    private final String price;
    LottoResultOutput(int correctCount, String price) {
        this.correctCount = correctCount;
        this.price = price;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public String  getPrice() {
        return price;
    }
}
