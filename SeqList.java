package com.example.jisuanqi;


public class SeqList<T>extends Object{
    protected Object[] element;
    protected int n;
    public SeqList(int length){
        this.element=new Object[length];
        this.n=0;
    }
    public SeqList(){
        this(64);
    }
    public SeqList(T[] v){
        this(v.length);
        for(int i=0;i<v.length;i++){
            this.element[i]=v[i];
            this.n=element.length;
        }
    }
    public boolean isEmpty(){
        return this.n==0;
    }
    public int size(){
        return this.n;
    }
    public T get(int i){
        if(i>=0&&i<this.n)
            return (T)this.element[i];
        return null;
    }
    public void set(int i,T x){
        if(i>=0&&i<this.n)
            this.element[i]=x;
    }
    public int insert(int i,T x){
        if(i<0) i=0;
        if(i>this.n) i=this.n;
        Object[] s=this.element;
        if(this.n==element.length){
            this.element=new Object[s.length*2];
            for(int j=0;j<i;j++)
                this.element[j]=s[j];
        }
        for(int j=this.n-1;j>=i;j--)
            this.element[j]=s[j];
        this.element[i]=x;
        this.n++;
        return i;
    }
    public int insert(T x){
        return this.insert(this.n,x);
    }
    public T remove(int x){
        if(this.n>0&&x>=0&&x<this.n){
            T o=(T)this.element[x];
            for(int j=x;j<this.n-1;j++)
                this.element[j]=this.element[j+1];
            this.element[this.n-1]=null;
            this.n--;
            return o;

        }
        return null;
    }
    public String  toString(){
        String s=this.getClass().getName()+"(";
        if(this.n>0)
            s+=this.element[0].toString();
        for(int i=1;i<this.n;i++)
            s+=","+this.element[i].toString();
        return  s+")";
    }


}
