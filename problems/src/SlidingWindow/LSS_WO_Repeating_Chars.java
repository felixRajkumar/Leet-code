package SlidingWindow;

import java.util.HashMap;

class LSS_WO_Repeating_Chars {

	/*
        Problem breakdown - We need to find the length of consequent sequence of characters which has no duplicates
    
        Solution breakdown - Sliding window / Why ?
        
                             Because we are finding length by computing continuos characters
    
                           - Use two pointers left and right
                           
                                    - Increase the right pointer as long as our condition is true
                                    
                                    - Increase the left pointer if the condition is false
                                    
                                    - While increasing the right pointer , make sure to calculate the length
                                    
                           - As long as our computed string has unique characters, increase the right pointer
                           
                           - else increase the left pointer
                           
                           - To check if the character has already there in our string we will use HashMap
                           
                           - abcabcbb 
                           
                           - 
                                        
    
    */


	public int lengthOfLongestSubstring(String s) {


		int left = 0;

		int n = s.length();

		if(n == 0)
			return 0;

		StringBuilder sb = new StringBuilder();

		HashMap<Character, Integer> map = new HashMap<>();

		map.put(s.charAt(left), 1);

		sb.append(s.charAt(left));

		int len = 1;

		int max_len = 1;

		for(int right = 1; right < n;)
		{
			if(!map.containsKey(s.charAt(right)))
			{
				sb.append(s.charAt(right));
				map.put(s.charAt(right), 1);
				max_len = Math.max(sb.length(), max_len);
				right++;
			}
			else
			{
				sb.deleteCharAt(0);
				map.remove(s.charAt(left));
				left++;
			}
		}
		return max_len;
	}
}