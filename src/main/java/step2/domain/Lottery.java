package step2.domain;

import step2.util.Util;

import java.util.List;

public class Lottery {

    private List<LottoNumber> lottoNumbers;

    public Lottery() {
        lottoNumbers = Util.getShuffled();
        Util.getSorted(lottoNumbers);
    }

    public Lottery(List<LottoNumber> winningNumbers) {
        Util.getSorted(winningNumbers);
        this.lottoNumbers = winningNumbers;
    }

    /**
     * 생성된 번호를 리턴하는 메소드
     * @return 생성된 로또 번호 객체
     */
    public List<LottoNumber> getNumbers() {
        return this.lottoNumbers;
    }

    /**
     * 당첨 번호와 현재 복권을 매칭하는 메소드
     * @param winningLottery 당첨 로또 번호 ([1,2,3,4,5,6])
     */
    public int match(WinningLottery winningLottery) {
        int count = 0;

        for (LottoNumber winningNumber : winningLottery.getWinningNumbers()) {
            count += this.getMatched(winningNumber, this.lottoNumbers);
        }
        return count;
    }

    /**
     * 당첨 번호와 현재 복권의 번호들과 같은지 비교
     * @param number 당첨 번호 (1)
     * @param lottoNumbers 현재 복권의 숫자들 ([8, 21, 23, 41, 42, 43])
     */
    private int getMatched(LottoNumber number, List<LottoNumber> lottoNumbers) {
        int count = 0;

        for (LottoNumber lottoNumber : lottoNumbers) {
            count += number.compareNumber(lottoNumber);
        }

        return count;
    }

}
