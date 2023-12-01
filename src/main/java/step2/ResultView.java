package step2;

public class ResultView {

    public ResultView() {
    }

    public void printLotto(String lottoNum){
        System.out.println(lottoNum);
    }

    public void printLottoCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }

    public void printWinningStatics(){
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("--------------");
    }

    public void printResult(String returnRate){
        System.out.println("총 수익률은 "+returnRate+"입니다.");
    }
}
