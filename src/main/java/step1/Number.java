package step1;

public class Number {
    private int number;

    public Number(){
        this.number = 0;
    }
    public Number(String string){
        try{
            this.number = Integer.parseInt(string);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(string+" cannot conver to number");
        }

        if(this.number < 0) throw new IllegalArgumentException("negative number cannot be used");
    }

    public void add(Number addNumber){
        number += addNumber.getNumber();
    }

    public int getNumber(){
        return number;
    }
}
