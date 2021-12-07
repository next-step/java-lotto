package lotto;

public class LottoApplication {
    public static void main(String[] args) {
        LottoNumbers lottoNumbers = LottoMachine.generateLottoNumber();
        Lotto lotto = Lotto.from(lottoNumbers);
    }
}
