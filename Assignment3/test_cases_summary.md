## Summary of all the Test Cases

### Bot Class Tests 

1. test_getInput() - this tests if our getInput() which is a getter method , is able to convert our input into a lowercase input, and then return that string.
2. test_getResponse() - will test if the get responses returns the right string, matching the json dictionary defined in responses.json
3. Test_check_goodbye() - this will check if the method is able to look for the word bye in our string. So that the program can end the app.
4. Test_goodbye() - this will check if the goodbye methods returns the goodbye string. This will fail if the goodbye string is changed at any point.
5. Test_greet() - this will test if the greet method is still returning the greet string , we expect it to return.
6. Test_exists_in_input() - this will test if the key exists in target string. The first test case will always pass since the strings are the same.

### POS Tagger Test

1. Test_getProperNoun() - tests if the method is correctly able to retrieve the proper noun out of the string. It will fail if the proper noun does not start with a capital letter.
   - The second test is also expected to pass , since both strings contain the same word.

### Optimizer Class Tests

1. Test_getoptimized() -This test will test if the getOptimized function is returing us an optimzed output of any input string we feed it.
2. Test_removePunc() - tests if the remove puctuation is able to remove all the punctuations from a string.



