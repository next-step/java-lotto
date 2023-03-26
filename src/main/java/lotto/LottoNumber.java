package lotto;

public class LottoNumber {
    private int num;

    public LottoNumber(int num){
        this.num = num;
    }

    public int getNum(){
        return num;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj.getClass() != this.getClass()){
            return false;
        }
        if(this.getNum() == ((LottoNumber) obj).getNum()){
            return true;
        }
        return false;
    }

}
