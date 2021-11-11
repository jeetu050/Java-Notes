class Fact extends Thread{
    private int n;
    private int fac=1;
    public Fact(int n,String name)
    {                            
        super(name);
        this.n=n;                                                               
    }                                                                           
    public void run()                                                           
    {
        try{
            while(n>1)
            {
                fac=fac*n;
                n--;
                Thread.sleep(500);
            }
            System.out.println("Factorial is "+fac);
        }
        catch(InterruptedException ex)
        {
            System.out.println(getName()+" thread interrupted");
        }
    }
}

class Prime extends Thread{
    private int n;
    private int count=0;
    public Prime(int n,String name)
    {
        super(name);
        this.n=n;
    }
    public void run()
    {
        try
        {
            for(int i=2;i<n;i++)
            {
                count=0;
                for(int j=2;j<i;j++)
                {
                    if(i%j==0)
                    {
                        count++;
                        break;
                    }
                }
                if(count==0)
                    System.out.println(i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException ex)
        {
            System.out.println(getName()+" thread interrupted");
        }
    }
}


public class Assigment {
    public static void main(String[] args) {
        Fact f1=new Fact(5,"fact");
        Prime p1=new Prime(10,"prime");
        f1.start();
        p1.start();
    }
}