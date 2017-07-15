public Char[] encodeSpaces(Char[] str, int length){
	//validate input
	int numberOfSpaces = 0;
	for (int i = 0; i <= length; i++){
		if(str[i] == ' '){
			numberOfSpaces++;
		}
	}
	int i = length;
	int j = length + (numberOfSpaces * 2);
	while( i >= 0 ){
		if(str[i] != ' '){
			str[j] = str[i];
			i--;
			j--;
		}else{
			str[j] = '0';
			str[j-1] = '2';
			str[j-2] = '%';
			j -=3;
			i--;
		}
	}
}
//Time : O(N)