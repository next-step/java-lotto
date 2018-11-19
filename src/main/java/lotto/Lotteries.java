package lotto;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//로또 카운트 만큼 생성하기
public class Lotteries {
    private static final String DELIMITER = ", ";
    private List<Lotto> lotteries;
    private int lottoTotalNum;

    public Lotteries(int lottoTotalNum) {
        this.lottoTotalNum = lottoTotalNum;
        this.lotteries = new ArrayList<Lotto>();
    }

    public List<Lotto> buyLotto(String[] manualLotto) {
        //수동으로 입력한 로또번호들을 나눠서 Lotteries에 insert한다.

        if (manualLotto.length > 0) {
            try {
                insertIntoLotteries(manualLotto);
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //자동으로 입력할 로또 숫자만큼 받아온다.
        for (int i = 0; i < this.lottoTotalNum - manualLotto.length; i++) {
            Lotto lotto = new Lotto(new HashSet());
            lotto.generateLottoNumber();
            this.lotteries.add(lotto);
        }
        return lotteries;
    }

    public void insertIntoLotteries(String[] manualLotto) {
        for (String oneLotto : manualLotto) {
            String[] oneNumbers = oneLotto.split(DELIMITER);
            this.lotteries.add(new Lotto(convertManualLotteries(oneNumbers)));

        }
    }

    public Set<LottoNo> convertManualLotteries(String[] oneNumbers) {
        Set<LottoNo> manualLotto = new HashSet<LottoNo>();
        for (String number : oneNumbers) {
            LottoNo num = LottoNo.of(number);
            manualLotto.add(num);

        }
        return manualLotto;

    }

}
