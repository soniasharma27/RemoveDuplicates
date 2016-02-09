# RemoveDuplicates
The purpose of this class is to provide different implementation of removing duplicates from int array .

1) removeDupUsingHashSet This solution will use the hashset to remove the duplicates from the Int Array as hashset does not allow duplicate elements.
Positive
Hashset will automatically remove the duplicates from Int Array. No need to write separate logic for the same
Code will be error free as writing own logic can be error prone if we miss any condition.

Negative
HashSet does not maintain the insertion order


2) removeDupUsingLinkedHashSet This solution will use Linkedhashset to remove the duplicates from Int Array.

Positive This will maintain the insertion order of the elements even after the removal of duplicate elements Code will be error free as writing own logic can be error prone if we miss any condition.

Note: This will overcome the negative of first method

Negative LinkedHashSet requires more memory than HashSet as it also maintains LinkedList along with HashMap to store its elements.

3) removeDupUsingSortedAray This solution will sort the array and then remove the duplicates. Note: This solution will be relevant if insertion order is not important 

Positive -By sorting the array we can remove the duplicates without using any collection element. -Performance is good if array doesn't contain many elements.

Negative -This implementation will not maintain any insertion order. -If Array contains thousands of elements performance will be slow as compared to using HashSet.

These are few of the implementations that we can use to remove duplicates from array. In general if we dont want to store duplicates we should not use array instead we should use Collection like HashSet as these will automatically remove the duplicates. Arraya are fixed length data structure so everytime you make changes you have to create new array. 
