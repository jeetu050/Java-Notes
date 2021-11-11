class MyThread extends Thread{
    public MyThread(String name){
        super(name);
        System.out.println("Thread details: "+this);
    }

    public void run(){
        try{
            for(int i=2;i<=10;i+=2){
                System.out.println(getName()+":"+i);
                Thread.sleep(500);
            }
            System.out.println(getName()+" finished!");
        }
        catch(InterruptedException ex){
            System.out.println(getName()+" thread interrupted");
        }
    }
}

class UseMyThread{
    public static void main(String [] args){
        MyThread m1=new MyThread("child");
        m1.start();
        System.out.println("m1 is alive ?"+m1.isAlive());
        try{
            for(int i=1;i<=10;i+=2){
                System.out.println("main thread:"+i);
                Thread.sleep(1000);
            }
            System.out.println("main thread finished!");
            System.out.println("m1 is alive ?"+m1.isAlive());

        }
        catch(InterruptedException ex){
            System.out.println("main thread interrupted");
        }
    }
}