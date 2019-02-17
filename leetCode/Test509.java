package leetCode;

public class Test509 {
    public int fib(int N) {
        int fib1=0;
        int fib2=1;
        int fib=0;
        if(N==0)
            return fib;
        if(N==1)
            return fib2;
        for(int i=2;i<=N;i++){
            fib=fib1+fib2;
            fib1=fib2;
            fib2=fib;
        }
        return fib;
    }
}
