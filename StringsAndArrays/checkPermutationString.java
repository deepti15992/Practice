public Boolean checkPermutationString(String s1, String s2){
	if(s1 == null || s2 == null)
		return false;
	if(s1.length() == 0 || s1.length() == 0 || s1.length() != s2.length())
		return false;
	
	String sortedS1 = Arrays.sort(s1.toCharArray());
	String sortedS2 = Arrays.sort(s2.toCharArray());
	if(sortedS1.equals(sortedS2))
		return true;
	else
		return false;
}
// O(NLogN)