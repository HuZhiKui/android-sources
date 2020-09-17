package com.example.jisuanqi;

public class YouXian {
    public StringBuffer toPos(String in){
        Stack<String> sta=new SeqStack<String>(in.length());
        StringBuffer pos=new StringBuffer(in.length()*2);
        int i=0;
        while(i<in.length()){
            char cc=in.charAt(i);

            switch(cc){
                case '+':case '-':
                    while(!sta.isEmpty()&&!sta.peek().equals("("));
                    pos.append(sta.pop());
                    sta.push(cc+""); i++;break;
                case '*':case'/':
                    while(!sta.isEmpty()&&(sta.peek().equals("*")||sta.peek().equals("/")))
                        pos.append(sta.pop());
                    sta.push(cc+""); i++;break;

                case'(':
                    sta.push(cc+"");
                    i++;break;
                case')':
                    String o=sta.pop();
                    while(o!=null&&!o.equals("(")){
                        pos.append(o);
                        o=sta.pop();
                    }
                    i++;break; default:
                    while(i<in.length()&&cc>='0'&&cc<='9'){
                        pos.append(cc);i++;
                        if(i<in.length())
                            cc=in.charAt(i);
                    }
                    pos.append(" ");
            }
        }
        while(!sta.isEmpty())
            pos.append(sta.pop());
        return pos;
    }
    public  int toV(StringBuffer pos){
        Stack<Integer>sta=new LinkedStack<Integer>();
        int v=0;
        for(int i=0;i<pos.length();i++){
            char cb=pos.charAt(i);
            if(cb>='0'&&cb<='9'){
                v=0;
                while(cb!=' '){
                    v=v*10+cb-'0';
                    cb=pos.charAt(++i);
                }
                sta.push(v);
            }
            else
            if(cb!=' '){
                Integer  q=sta.pop(), w=sta.pop();
                switch(cb){
                    case '+':  v=w+q;  break;
                    case '-':  v=w-q;  break;
                    case '*':  v=w*q;  break;
                    case '/':  v=w/q;  break;
                }

                sta.push(v);
            }
        }
        return sta.pop();
    }
}
