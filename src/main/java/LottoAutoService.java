import java.util.*;

public class LottoAutoService {

    private int num;
    private int price;

    List<Integer> countList;
    List<Integer> bonusList;

    public LottoAutoService(){

    }
    public LottoAutoService(int price,int num){
        this.price = price;
        this.num = num;
    }
    public List<List> setLotto() {
        Random random = new Random();
        List<List> result = new ArrayList<>();

        for (int x = 0; x < num; x++) {
            List<Integer> num = new ArrayList<>();

            for (int i = 0; i < 6; i++) {
                num.add(random.nextInt(45) + 1);
            }
            Collections.shuffle(num);
            Collections.sort(num);
            result.add(num);
        }

        return result;
    }
    public List<Integer> statistic(List<List> result,List<Integer> winningNum) {

        countList = new ArrayList<>() ;
        for(int i=0; i<result.size();i++) {
            int count =0;
            for(int j=0;j<winningNum.size();j++){
                if (result.get(i).contains(winningNum.get(j))) {
                    count++;

                }
            }
            countList.add(count);
        }
        return countList;

    }
    public List<Integer> statisticBonus(List<List> result,int bonus) {
        bonusList = new ArrayList<>();

        for(int i=0;i<result.size();i++){
            int count = 0 ;
            for(int j=0;j<countList.size();j++) {
                if(countList.get(j)==5&&result.get(i).contains(bonus)) {
                    countList.remove(j);
                    j--;
                }
                bonusList.add(count);
            }
        }
        return bonusList;
    }

    public double revenue(WinningCount winningCount) {
        int revenueNum = (5000* winningCount.three + 50000* winningCount.four + 1500000* winningCount.five + 30000000* winningCount.fiveBonus+2000000000* winningCount.six)/price;
        return revenueNum;
    }
}
