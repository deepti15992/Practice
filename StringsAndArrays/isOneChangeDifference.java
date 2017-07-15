public Boolean isOneChangeDifference(String s1, String s2){
	int table1 = initHashTable(s1);
	int table2 = initHashTable(s2);
	int insert = 0, delete = 0;
	for(int i = 0; i < 26; i++){
		if(table1[i] > table2[i])
			insert += table1[i] - table2[i];
		if(table1[i] < table2[i])
			delete += table2[i] - table1[i]
	}
	if(insert == 1 && (delete == 0 || delete == 1))
		return true;
	if(insert == 0 && delete == 1)
		return true;
	return false;
}

private int[] initHashTable(String str){
	int table[] = new int[27];
	Arrays.fill(table, 0);
	for(Char c : str.toCharArray()){
		table[hashOf(c)]++;
	}
}

private int hashOf(Char c){
	if(Character.isLetter(c)){
		return Character.toLowerCase(c) - 'a';
	}
	return 26;
}