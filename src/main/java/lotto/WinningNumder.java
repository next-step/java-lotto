package lotto;

enum SameCount{
    COUNT_THREE("3개 일치"),
    COUNT_FOUR("4개 일치"),
    COUNT_FIVE("5개 일치"),
    COUNT_FIVE_BONUS("5개 일치, 보너스볼 일치"),
    COUNT_SIX("6개 일치");

    private String sameCountValue;
    SameCount(String sameCountValue){
        this.sameCountValue = sameCountValue;
    }

    public String getSameCount(){
        return sameCountValue;
    }
}

public class WinningNumder {

    Lotto lotto = new Lotto();



}
