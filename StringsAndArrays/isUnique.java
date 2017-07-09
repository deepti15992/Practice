public Boolean isUnique(String str){
	BitSet bitSet = new BitSet(26); //change to represent casesensitive alphanumeric etc
	char a = 'a';
	int ascii = (int) a;
	for(int i = 0; i<str.size(); i++){
		int value = str.charAt(i) - ascii;
		if(bitSet.get(value) == true )
			return false;
		else
			bitSet.set(value);
	} 
	return true;
}

//O(N)

//with bitVector

public Boolean isUnique(String str){
	int checker = 0;
	for(int i = 0; i < str.length(); i++){
		int value = str.charAt(i) - 'a';
		if((checker & (1 << value)) > 0)
			return false;
		checker = checker | (1 << value);
	}
	return true;
}
