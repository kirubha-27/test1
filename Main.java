import java.util.*;


public class Main
{
    static boolean isAlpha(char c){
        if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
            return true;
        }
        return false;
    }
    static boolean isOp(char c){
        if(c=='+'||c=='-'||c=='*'||c=='/'||c=='%'){
            return true;
        }
        return false;
    }

    public static boolean isValid(String s) {
        Deque<Character> ss = new ArrayDeque<>();
        char[] m = s.toCharArray();
        for(int i=0;i<m.length;i++){
            if(m[i]=='('||m[i]=='{'||m[i]=='['){
                ss.push(m[i]);
                continue;
            }else if(ss.isEmpty()){
                return false;
            }else if(isAlpha(m[i])){
                if(i!=m.length-1&&isAlpha(m[i+1])){
                    return false;
                }
                continue;
            }else if(isOp(m[i])){
                if(!((i!=0||i!=m.length-1)&&(isAlpha(m[i-1])&&isAlpha(m[i+1])))){
                    return false;
                }
                continue;
            }
            char d = ss.pop();
            if(d=='('&&m[i]!=')')
                return false;
            else if(d=='{'&&m[i]!='}')
                return false;
            else if(d=='['&&m[i]!=']')
                return false;

        }
        return ss.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(ab)(ab+)";
        if(isValid(s)){
            System.out.println("valid");
        }else{
            System.out.println("Invalid");
        }
    }
}
