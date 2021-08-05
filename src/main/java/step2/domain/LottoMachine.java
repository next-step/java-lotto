package step2.domain;

public class LottoMachine {
    private String lastLottoNum;

    public LottoMachine(String lastLottoNum) {
        this.lastLottoNum = lastLottoNum;
        checkValidInput();
    }


    private void checkValidInput() {
        String[] lastLottoNumArray = stringSpliter();
        if (lastLottoNumArray.length != 6) {
            throw new IllegalArgumentException("로또 당첨번호는 6개를 입력하세요. 당첨번호는 ', '로 구분을 하고 있습니다.");
        }
    }

    private String[] stringSpliter() {
        return lastLottoNum.split(", ");

    }
}
