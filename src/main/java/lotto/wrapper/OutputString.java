package lotto.wrapper;

public class OutputString  {
    private String str;
    public OutputString(String str) {
        this.str = str;
    }
    public String getString(){
        return str;
    }
    public void print(){
        System.out.println(str);
    }
}