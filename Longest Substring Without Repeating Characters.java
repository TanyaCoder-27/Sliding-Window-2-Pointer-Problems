/*
Longest Substring Without Repeating Characters


Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/
static int solve(String s) {
    // Step 1: Create a HashMap to store characters and their positions
    HashMap<Character, Integer> mpp = new HashMap<Character, Integer>();

    // Step 2: Initialize pointers and variables
    int left = 0, right = 0;
    int n = s.length();
    int len = 0;

    // Step 3: Iterate through the string
    while (right < n) {
        // Step 4: If character at 'right' is already in the HashMap, update 'left' pointer
        if (mpp.containsKey(s.charAt(right))) {
            left = Math.max(mpp.get(s.charAt(right)) + 1, left);
        }

        // Step 5: Add/update character at 'right' in the HashMap
        mpp.put(s.charAt(right), right);

        // Step 6: Calculate the length of the current substring and update 'len' if necessary
        len = Math.max(len, right - left + 1);

        // Step 7: Move the 'right' pointer to the next position
        right++;
    }

    // Step 8: Return the length of the longest substring without repeating characters
    return len;
}

/*
Create a HashMap: mpp stores each character and its last occurrence position.

Initialize Pointers: left and right are the two pointers used for sliding window technique. n is the length of the string s, and len keeps track of the maximum length of the substring without repeating characters.

Iterate through the string: The while loop continues until the right pointer reaches the end of the string.

Check for Repeating Characters: If the character at the right position is already in the mpp, update the left pointer to the position after the last occurrence of this character to ensure there are no repeating characters.

Update HashMap: Add or update the position of the character at the right pointer in the mpp.

Calculate Length: Calculate the length of the current substring and update len if the current length is greater than the previous len.

Move Right Pointer: Increment the right pointer to expand the window.
*/
