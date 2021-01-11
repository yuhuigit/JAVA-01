package homework1;

//cd src
////javac homework1/HelloByteCode.java
////javap ‐c homework1/HelloByteCode.class
////javap ‐c ‐verbose homework1/HelloByteCode

public class HelloByteCode {

    private String s = "p:";
    private int i  = 200;
    private double d  = 200.00;
    private float f  = 200.00f;

    public static void main(String[] args) {
        HelloByteCode obj = new HelloByteCode();
        obj.print("hello",1000,1000.00,1000.00f);

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum+=i;
        }
        System.out.println("sum = " + sum);
    }

    private void print(String p2,int i2,double d2,float f2){
        s = s+p2;
        i = i+i2;
        d = d +d2;
        f = f+f2;
        System.out.println(s+", i = "+i+", d = "+d+", f = "+f);
    }

}
