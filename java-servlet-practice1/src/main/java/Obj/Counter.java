package Obj;

public class Counter {
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;


    public Counter(){
        this.count=0;
    }

    public void increaseCount(){
        this.count++;
    }



}
