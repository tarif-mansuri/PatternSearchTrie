//$Id$
package com.trie.pattern;

public class Node {
	char data;
	boolean isWordEnding;
	Node[] children = new Node[26];
	public Node(char data) {
		this.data = data;
		this.isWordEnding = false;
	}
}
