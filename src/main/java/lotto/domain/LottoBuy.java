package lotto.domain;

public class LottoBuy {

    private static final int lottoPrice = 1000;
    private final int MINIMUM_GAME_COUNT = 1;
    private final String INVALID_GAME_COUNT = "게임을 시작할 수 없습니다.";
    private int lottoCount;
    private int inputMoney;

    public void makeLottoTryCount(String getMoney) {
        inputMoney = Integer.parseInt(getMoney);
        lottoCount = inputMoney / lottoPrice;
        validateLottoTryCount(lottoCount);
    }

    private void validateLottoTryCount(int lottoTryCount) {
        if (lottoTryCount < MINIMUM_GAME_COUNT) {
            throw new IllegalArgumentException(INVALID_GAME_COUNT);
        }
    }

    public int getMoney() {
        return inputMoney;
    }

    public int getCount(){
        return lottoCount;
    }
}
