/* Create a palindrome string from the given string.
If a palindrome cannot be created for the iven string, output "palindrome cannot be created"
else output the palindrom string
*/


//uncomment this if you want to read input.
import java.util.*;
import java.util.Scanner;


class TestClass {
    public static void main(String args[] ) throws Exception {
       System.out.println("Enter the string");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); 
        int n = str.length();
        char c[] = str.toCharArray();
        StringBuilder new1 = new StringBuilder(str);
        int value = 0;
        char key;
        int x= 0;
        int start=0,end=n;
        HashMap <Character, Integer> countMap = new HashMap<Character, Integer>();
        for(int i=0;i<n;i++)
        {
            if(! countMap.containsKey(c[i]))
            {
                countMap.put(c[i],1);
            }
            else
            {
                value = countMap.get(c[i]);
                countMap.put(c[i],value+1);
            }
        }
        int oddFlag = 0;
        
        Iterator<Map.Entry<Character, Integer>> itr = countMap.entrySet().iterator(); 
        System.out.println(new1);
         while(itr.hasNext()) 
        { 
             Map.Entry<Character, Integer> entry = itr.next(); 
             System.out.println("Key = " + entry.getKey() +  ", Value = " + entry.getValue()); 
              value = entry.getValue();
            key = entry.getKey();
             if(value%2 != 0)
            {
                 System.out.println("yes");
                 oddFlag++;
                System.out.println(oddFlag);
                if(oddFlag>1)
                {
                    System.out.println("Pallindrome is not possible");
                    break;
                }
            }
            
        }
        Iterator<Map.Entry<Character, Integer>> itr1 = countMap.entrySet().iterator();
        if(oddFlag<2)
        {
        while(itr1.hasNext()) 
        { 
            Map.Entry<Character, Integer> entry = itr1.next(); 
         //    System.out.println("Key = " + entry.getKey() +  ", Value = " + entry.getValue());
             value = entry.getValue();
            key = entry.getKey();
            if(value%2 == 0)
            {
                x= value/2;
               //new1 = new1.replace(new1.substring(start,x-1),key);
               //new1 = new1.replace(new1.substring(j-x,end),key);
                char[] charArray = new char[x];
                Arrays.fill(charArray, key);
                String copy = new String(charArray);
                System.out.println("copy"+copy);
                //new1 = new1.replace(start,x-1,copy);
                //new1 = new1.replace(j-x,end,copy);
                new1 = new1.replace(start,start+x,copy);
                new1 = new1.replace(end-x,end,copy);
                System.out.println("len"+new1.length());
                System.out.println(new1);
                start = start+x;
                end = end-x;
            }
            else
            {
                System.out.println("else");
                char[] charArray = new char[value];
                Arrays.fill(charArray, key);
                String copy1 = new String(charArray);
                System.out.println(copy1);
                new1 = new1.replace(n/2-((value-1)/2),(n/2-((value-1)/2))+value,copy1);
                System.out.println(new1);
            }
        }
    }
    }
}
