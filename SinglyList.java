package com.example.jisuanqi;


public class SinglyList<T> extends Object {
    public Node<T>head;
    public SinglyList(){this.head=new Node<T>();}
    public SinglyList(T[] v){
        this();
        Node<T> r=this.head;
        for(int i=0;i<v.length;i++){
            r.next=new Node<T>(v[i],null);
            r=r.next;
        }
    }
    public boolean isEmpty(){
        return this.head.next==null;
    }
    public T get(int i){
        Node<T> p=this.head.next;
        for(int j=0;p!=null&&j<i;j++)
            p=p.next;
        return(i>=0&&p!=null)?p.data:null;
    }
    public void set(int i,T x){

    }
    public int size(){
        int t=0;
        Node tt=this.head;
        while(tt!=null){
            t++;
            tt=tt.next;
        }
        return t;
    }
    public String toString(){
        String s=this.getClass().getName()+"(";
        for(Node<T>p=this.head.next;p!=null;p=p.next){
            s+=p.data.toString();
            if(p.next!=null)
                s+=",";
        }
        return s+")";
    }
    public Node<T>insert(int i,T x){
        Node<T>f=this.head;
        for(int j=0;f.next!=null&&j<i;j++)
            f=f.next;
        f.next=new Node<T>(x,f.next);
        return f.next;
    }
    public Node <T> insert (T x){
        return insert(Integer.MAX_VALUE,x);
    }
    public T remove(int i){
        Node<T> f=this.head;
        for(int j=0;f.next!=null&&j<i;j++)
            f=f.next;
        if(i>=0&&f.next!=null){
            T o=f.next.data;
            f.next=f.next.next;
            return o;
        }
        return null;
    }
    public void clear(){
        this.head.next=null;
    }
    public boolean search(T key){
        if(key.equals(head.data))
            return true;
        return false;
    }
}
