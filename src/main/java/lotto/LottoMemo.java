package lotto;

public class LottoMemo {
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;
    private double result = 0;

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }

    public double getResult() {
        return result;
    }

    public void markResult(LottoResult lottoResult){
        if(lottoResult.equals(LottoResult.FIRST)){
            first++;
        }
        if(lottoResult.equals(LottoResult.SECOND)){
            second++;
        }
        if(lottoResult.equals(LottoResult.THIRD)){
            third++;
        }
        if(lottoResult.equals(LottoResult.FOURTH)){
            fourth++;
        }
        if(lottoResult.equals(LottoResult.FIFTH)){
            fifth++;
        }
        result += reward(lottoResult);
    }

    private int reward(LottoResult lottoResult){
        if(lottoResult.equals(LottoResult.FIRST)){
            return 2000000000;
        }
        if(lottoResult.equals(LottoResult.SECOND)){
            return 30000000;
        }
        if(lottoResult.equals(LottoResult.THIRD)){
            return 1500000;
        }
        if(lottoResult.equals(LottoResult.FOURTH)){
            return 50000;
        }
        if(lottoResult.equals(LottoResult.FIFTH)){
            return 5000;
        }
        return 0;
    }

}

