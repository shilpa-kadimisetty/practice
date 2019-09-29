/* given an array of numbers and a value 'k', find the pairs in the array whose sum = k
Eg: a[] = 1, 2, 3, 4, 5, 6 
k = 6
pairs: [2,4], [3,3]*/
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
       Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        
        HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> out= new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> count = new HashMap<Integer,Integer>(); 
        int size = 1;
        for(String s: str.split(" "))
        {
            map.put(Integer.parseInt(s),k-Integer.parseInt(s));
             if(count.containsKey(Integer.parseInt(s)))
            {
              count.put(Integer.parseInt(s),count.get(Integer.parseInt(s))+1);
            }
            else
            count.put(Integer.parseInt(s),size);
           
        }
        
        Iterator<Map.Entry<Integer,Integer>> itr = map.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<Integer,Integer> entry = itr.next();
          //  System.out.println("Key:"+entry.getKey()+"Value:"+entry.getValue());
           if(map.containsKey(entry.getValue()))
           {
              // System.out.println("["+entry.getKey()+","+entry.getValue()+"]");
              if(!out.containsKey(entry.getValue()) && !out.containsValue(entry.getValue()))
              {
				if (entry.getValue()==entry.getKey() && count.get(entry.getKey())>1)
					out.put(entry.getKey(),entry.getValue());
				else if(entry.getValue()!=entry.getKey())
				  out.put(entry.getKey(),entry.getValue());
              }
           }
        }
        Iterator<Map.Entry<Integer,Integer>> itr1 = out.entrySet().iterator();
        while(itr1.hasNext())
        {
             Map.Entry<Integer,Integer> entry = itr1.next();
             System.out.println("["+entry.getKey()+","+entry.getValue()+"]");
        }
    }
}




