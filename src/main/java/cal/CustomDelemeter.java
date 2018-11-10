package cal;

public class CustomDelemeter {
    private String delemeter;

    public CustomDelemeter(){
        delemeter = ",|:";
    }

    public CustomDelemeter(String delemeter) {
        if(delemeter == null){
            throw new NullPointerException("분리자 입력해야해");
        }
        this.delemeter = delemeter;
    }

    public StringExpressions getSplitStr(StringExpression customExpression) {
        return new StringExpressions(customExpression.getExpression(delemeter));
    }


}
