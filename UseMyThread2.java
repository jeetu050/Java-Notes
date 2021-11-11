class MyThread2 implements Runnable{
    public void run(){
        try{
            for(int i=2;i<=10;i+=2){
                System.out.println("child:"+i);
                Thread.sleep(500);
            }
            System.out.println("child thread finished!");
        }
        catch(InterruptedException ex){
            System.out.println("child thread interrupted");
        }
    }
}

class UseMyThread2{
    public static void main(String [] args){
        MyThread2 m1=new MyThread2();
        Thread th=new Thread(m1);
        th.start();
        try{
            for(int i=1;i<=10;i+=2){
                System.out.println("main thread:"+i);
                Thread.sleep(1000);
            }
            System.out.println("main thread finished!");
        }
        catch(InterruptedException ex){
            System.out.println("main thread interrupted");
        }
    }
}