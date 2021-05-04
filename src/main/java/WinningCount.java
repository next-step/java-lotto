import java.util.List;

public class WinningCount {
    int three =0;
    int four = 0;
    int five = 0;
    int six = 0;
    int fiveBonus=0;

    List<Integer> countList;
    List<Integer> bonusList;

    public WinningCount(List<Integer> countList, List<Integer> bonusList) {
        this.countList = countList;
        this.bonusList = bonusList;

    }
    public void count() {
        fiveBonus = bonusList.size();

        for (int i=0;i<countList.size();i++) {
            if (countList.get(i) == 3) {
                three++;
            }
            if (countList.get(i) == 4) {
                four++;
            }
            if (countList.get(i) == 5) {
                five++;
            }
            if (countList.get(i) == 6) {
                six++;
            }
        }
    }

}
