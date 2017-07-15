public Boolean isPermutationOfPallindrome(String input){
	//validate input
	int size = input.length();
	Char[] str = input.toCharArray();
	int[] hashTable = new int[27];
	Arrays.fill(hashTable, 0);
	for(int i = 0; i < size; i++){
		int index = hashOf(str[i]);
		hashTable[index]++;
	}
	int numberOfSingles = 0;
	for(int i = 0; i < 26; i++){
		if(hashTable[i] % 2 != 0){
			numberOfSingles++;
			if(numberOfSingles > 1)
				return false;
		}			
	}
	return true;
}

private int hashOf(Char c){
	if(c == ' '){
		return 26;
	}
	return Character.toLowerCase(c) - 'a';
}
//Time O(N) space sizeOfHashTable

//Bit Vector
public Boolean bitVector(String input){
	//validate input
	int size = input.length();
	Char[] str = input.toCharArray();
	int count = 0;
	for(int i = 0; i < size; i++){
		int index = hashOf(str[i]);
		int mask  = (1 << index);
		if(count & mask == 0)
			count = count | mask;
		else
			count = count & ~mask;
	}
	return (count & (count - 1)) == 0;
}