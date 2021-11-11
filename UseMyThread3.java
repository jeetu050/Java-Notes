class MyThread3 implements Runnable {
    public Thread th;
    public MyThread3(String name){
        th=new Thread(this,name);
        th.start();
    }
    public void run(){
        try{
            for(int i=2;i<=10;i+=2){
                System.out.println(th.getName()+":"+i);
                Thread.sleep(500);
            }
            System.out.println(th.getName()+" thread finished!");
        }
        catch(InterruptedException ex){
            System.out.println(th.getName()+" thread interrupted");
        }
    }
}

class UseMyThread3{
    public static void main(String [] args){
        MyThread3 m1=new MyThread3("child 1");
        MyThread3 m2=new MyThread3("child 2");
        MyThread3 m3=new MyThread3("child 3");
        
        try
        {
            while(m1.th.isAlive() || m2.th.isAlive() || m3.th.isAlive())
                Thread.sleep(1000);
            
        }
        catch(InterruptedException ex){
            System.out.println("main thread interrupted");
        }
        System.out.println("main thread finished!");
    }
}