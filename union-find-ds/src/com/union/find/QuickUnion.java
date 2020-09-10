package com.union.find;

import java.util.Scanner;

public class QuickUnion {
	
	int id[];
	public QuickUnion(int N) {
		this.id=new int[N];
		for(int i=0;i<id.length;i++)
			id[i]=i;
	}
	public int root(int p)
	{
		int i=p;
		while(i!=id[i])
		{
			i=id[i];
		}
		return i;
	}
	public void union(int p,int q) {
		int proot=root(p);
		int qroot=root(q);
		id[qroot]=proot;
	}
	public boolean connected(int p,int q) {
		return root(p)==root(q);
	}
	public static void main(String[] args) {
		System.out.println("Invoking main in QuickUnion");
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		QuickUnion uf = new QuickUnion(N);
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
