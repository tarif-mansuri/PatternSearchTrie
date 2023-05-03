//$Id$
package com.trie.pattern;

import java.util.ArrayList;

public class WordsLibrary {
	private Node root;
	public WordsLibrary() {
		this.root = new Node('#');
	}
	
	public void insertWord(String word, Node root) {
		char c = word.charAt(0);
		Node temp = root.children[c-'a'];
		if(temp == null) {
			temp = new Node(c);
			root.children[c-'a'] = temp;
		}
		if(word.length()==1) {
			temp.isWordEnding = true;
			return;
		}
		insertWord(word.substring(1), temp);
	}
	
	public static boolean searchWord(String word, Node root) {
		if(word == null || root == null) {
			return false;
		}
		char c = word.charAt(0);
		Node temp = root.children[c-'a'];
		if(temp == null) {
			return false;
		}else if(word.length() == 1 && temp.isWordEnding == true) {
			return true;
		}else if(word.length() == 1 && temp.isWordEnding == false) {
			return false;
		}
		else {
			return searchWord(word.substring(1), temp);
		}
		
	}
	
	public ArrayList<String> searchPattern(String pattern){
		ArrayList<String> list = new ArrayList<>();
		searchPatternHelper(list, this.root, pattern, new ArrayList<>());
		return list;
	}
	
	private void searchPatternHelper(ArrayList<String> list, Node root, String pattern, ArrayList<Character> matchedString) {
		//UNDER CONSTRUCTION 
		if(root == null) {
			return;
		}
		char c = pattern.charAt(0);
		Node temp = root.children[c-'a'];
		if(temp == null) {
			for(int i =0;i<26;i++) {
				temp = root.children[i];
				if(temp!=null) {
					searchPatternHelper(list, temp, pattern, new ArrayList<>());
				}
			}
		}else if(pattern.length() == 1){
			if(temp.isWordEnding == true) {
				list.add(pattern);
			}
		}
	}
}
