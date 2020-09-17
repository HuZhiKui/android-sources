package com.example.jisuanqi;


public class LinkedStack<T>implements Stack {
    private SinglyList <T>list;
    public LinkedStack(){
        this.list=new SinglyList<T>();
    }
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public T peek() {
        return this.list.get(0);
    }

    public T pop() {
        return this.list.remove(0);
    }
    public void push(Object x) {
        this.list.insert(0, (T) x);
    }

}
