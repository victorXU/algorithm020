import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char sArray[] = s.toCharArray();
        char tArray[] = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray,tArray);
    }


    public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> Smap = new HashMap<>();
        char sArray[] = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            Smap.put(sArray[i],Smap.getOrDefault(sArray[i],0)+1);
        }
        for (char c : t.toCharArray()) {
            if (!Smap.containsKey(c)){
                return false;
            }else if (Smap.get(c)>1){
                Smap.put(c,Smap.get(c)-1);
            }else {
                Smap.remove(c);
            }
        }
        return Smap.size()==0;
    }

}
