package view;

public class ShowResult {
    public static void result(int[] rankRecord, int sum,int tries) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치(5000원)- "+rankRecord[4] +"개");
        System.out.println("4개 일치(50000원)- "+rankRecord[3] +"개");
        System.out.println("5개 일치(1500000원)- "+rankRecord[2] +"개");
        System.out.println("6개 일치(2000000000원)- "+rankRecord[1] +"개");
        if(sum ==0 ) {
            System.out.println("총 수익률은 0 입니다.");
            return;
        }
        System.out.println("총 수익률은 "+(double)sum/(tries*1000)+" 입니다.");
    }
}
