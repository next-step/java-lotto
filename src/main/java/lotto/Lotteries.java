package lotto;

import lotto.lottoView.InputView;

import java.util.ArrayList;
import java.util.List;

//로또 카운트 만큼 생성하기
public class Lotteries {
    private static final String DELIMITER = ", ";
    private List<Lotto> lotteries;
    private int lottoTotalNum;
    private int lottoManualNum;

    public Lotteries(LottoInit init) {
        this.lottoTotalNum = init.getTotalCount();
        this.lottoManualNum = init.getManualCount();
        this.lotteries = new ArrayList<Lotto>();
    }

    public List<Lotto> buyLotto() {
        //수동으로 입력한 로또번호들을 나눠서 Lotteries에 insert한다.
        if (this.lottoManualNum > 0) {
            String[] manualLotto = InputView.inputManualNumbers(this.lottoManualNum);
            try {
                insertIntoLotteries(manualLotto);
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
                buyLotto();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //자동으로 입력할 로또 숫자만큼 받아온다.
        for (int i = 0; i < this.lottoTotalNum - this.lottoManualNum; i++) {
            Lotto lotto = new Lotto();
            lotto.generateLottoNumber();
            this.lotteries.add(lotto);
        }
        return lotteries;
    }

    public void insertIntoLotteries(String[] manualLotto) throws NumberFormatException, Exception {
        for (String oneLotto : manualLotto) {
            String[] oneNumbers = oneLotto.split(DELIMITER);
            this.lotteries.add(new Lotto(convertIntegerArray(oneNumbers)));

        }
    }

    public LottoNo[] convertIntegerArray(String[] oneNumbers) throws NumberFormatException, Exception {
        LottoNo[] result = new LottoNo[oneNumbers.length];
        for (int i = 0; i < oneNumbers.length; i++) {
            try {
                result[i] = new LottoNo(Integer.parseInt(oneNumbers[i]));
            } catch (NumberFormatException nfe) {
                throw new NumberFormatException("번호 포맷이 잘못 입력되었습니다. 다시 입력 바랍니다.");
            } catch (Exception e) {
                throw new Exception("예외가 발생했습니다.", e);
            }
        }
        return result;
    }

}
