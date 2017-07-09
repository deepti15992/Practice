public Boolean isUnique(String str){
	BitSet bitSet = new BitSet(27); //change to represent casesensitive alphanumeric etc
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