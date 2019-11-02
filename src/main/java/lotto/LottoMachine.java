package lotto;

public class LottoMachine {

    private static int LOTTO_PRICE = 1000;

    private final LottoView lottoView;
    private LottoNumbers lottoNumbers;

    public LottoMachine(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    void start() {
        try {
            createLottoNumbers();
        } catch (NumberFormatException exception) {
            return;
        } catch (IllegalArgumentException exception) {
            return;
        }

        
    }

    private void createLottoNumbers() {
        int lottoCount = getLottoCount(lottoView.getMoney());
        lottoNumbers = new LottoNumbers(lottoCount);

        lottoView.showLottoNumbers(lottoNumbers);
    }

    private int getLottoCount(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }

        return money / LOTTO_PRICE;
    }

    private void checkWinningLottoNumber(LottoNumber winningNumber) {
        lottoView.showLottoRanks(lottoNumbers.getRanks(winningNumber));
    }
}
