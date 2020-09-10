/**
 * 
 */
package com.union.find;

import java.util.List;
import java.util.*;

/**
 * @author anjshaw
 *
 */
class QuickFind {
	
	int n;
	int objects[];
	List<List<Integer>> list;
	QuickFind(int n){
		this.n=n;
		objects=new int[this.n];
	for(int i=0;i<objects.length;i++)
		objects[i]=i;
	}
	public void union(int p,int q)
	{
		int pIndex=objects[p];
		int qIndex=objects[q];
		objects[p]=qIndex;
		for(int i=0;i<objects.length;i++)
		{
			if(objects[i]==pIndex)
				objects[i]=qIndex;
		}
	}
	public boolean connected(int p,int q) {
		return objects[p]==objects[q];
	}
	public static void main(String[] args) {
		System.out.println("Invoking main in QuickFind");
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		QuickFind uf = new QuickFind(N);
		 char c=' ';
		 do
		 {
		 int p = scanner.nextInt();
		 int q = scanner.nextInt();
		 if (!uf.connected(p, q))
		 {
		 uf.union(p, q);
		 System.out.println(p + " " + q);
		 }
		 else
			 System.out.println("connected");
		 System.out.println("Enter Y or y to continue");
		 c=scanner.next().charAt(0);
		 }while (c=='Y'||c=='y');
		scanner.close();
	}
}
