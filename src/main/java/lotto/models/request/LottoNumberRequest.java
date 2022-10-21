package lotto.models.request;

public class LottoNumberRequest {
    private final String number;

    private LottoNumberRequest(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }


    public static LottoNumberRequest of(String number) {
        return new LottoNumberRequest(number);
    }
}
